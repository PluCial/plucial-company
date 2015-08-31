package com.plucial.company.service;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.S3QueryResultList;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.plucial.company.dao.ArticleModelDao;
import com.plucial.company.meta.ArticleModelMeta;
import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.ArticleModel;
import com.plucial.company.model.UserModel;


public class ArticleService {
    
    private static ArticleModelDao dao = new ArticleModelDao();
    
    /**
     * IDから記事を取得
     * @param id
     * @return
     */
    public static ArticleModel get(long id) {
        Key key = createKey(id);
        ArticleModel model = Memcache.get(key.toString());
        if(model != null) return model;

        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * driveFileIdから記事を取得
     * @param driveFileId
     * @return
     */
    public static ArticleModel getArticleByDriveFileId(String driveFileId) {

        return dao.getArticleByDriveFileId(driveFileId);
    }
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static ArticleModel put(ArticleModel model) {
        // 永久化
        dao.put(model);
        
        // カテゴリの更新日付を更新
        ArticleCategoryModel categoryModel = model.getCategoryModelRef().getModel();
        categoryModel.setUpdateDate(new Date());
        ArticleCategoryService.put(categoryModel);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());

        return model;
    }
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static ArticleModel put(UserModel userModel, ArticleCategoryModel categoryModel, String driveFileId) {
        
        
        ArticleModel model = new ArticleModel();
        
        model.setDriveFileId(driveFileId);
        model.setUpdateDate(new Date());
        model.setCreateDate(new Date());
        
        model.getCreateUserModelRef().setModel(userModel);
        model.getCategoryModelRef().setModel(categoryModel);
        

        return put(model);
    }
    
    /**
     * 新しい記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public static S3QueryResultList<ArticleModel> getNewArticleList(String lang, int num, String cursor) {
        
        S3QueryResultList<ArticleModel> list = dao.getNewArticleList(num, cursor);
        
        // カテゴリModel を設定
        for(ArticleModel articleModel: list) {
            ArticleCategoryModel articleCategoryModel = ArticleCategoryService.get(articleModel.getCategoryModelRef().getKey().getId());
            articleModel.setArticleCategoryModel(articleCategoryModel);
        }
        
        return list;
    }
    
    /**
     * カテゴリの記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public static S3QueryResultList<ArticleModel> getArticleListByCategory(int num, ArticleCategoryModel categoryModel, String cursor) {
        S3QueryResultList<ArticleModel> list =  dao.getArticleListByCategory(num, categoryModel, cursor);
        
        // カテゴリModel を設定
        for(ArticleModel articleModel: list) {
            ArticleCategoryModel articleCategoryModel = ArticleCategoryService.get(articleModel.getCategoryModelRef().getKey().getId());
            articleModel.setArticleCategoryModel(articleCategoryModel);
        }
        
        return list;
    }
    
    /**
     * カテゴリの記事一覧を取得(サイトマップ用)
     * @param categoryModel
     * @return
     */
    public static List<ArticleModel> getArticleListByCategory(ArticleCategoryModel categoryModel) {
        return dao.getArticleListByCategory(categoryModel);
    }
    
    /**
     * キーの作成
     * @param articleModel
     * @param lang
     * @return
     */
    private static Key createKey(long id) {
        return Datastore.createKey(ArticleModelMeta.get(), id);
    }

}
