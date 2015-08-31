package com.plucial.company.service;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.plucial.company.dao.ArticleCategoryModelDao;
import com.plucial.company.meta.ArticleCategoryModelMeta;
import com.plucial.company.model.ArticleCategoryModel;


public class ArticleCategoryService {
    
    private static ArticleCategoryModelDao dao = new ArticleCategoryModelDao();
    
    /**
     * カテゴリの取得
     * @param category
     * @return
     */
    public static ArticleCategoryModel get(Long categoryId) {
        
        Key key = createKey(categoryId);
        ArticleCategoryModel model = Memcache.get(key.toString());
        if(model != null) return model;
        
        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * カテゴリリストの取得
     * @return
     */
    public static List<ArticleCategoryModel> getCategoryList() {
        return dao.getCategoryList();
    }
    
    /**
     * カテゴリのPUT
     * @param model
     * @return
     */
    public static ArticleCategoryModel put(ArticleCategoryModel model) {
        
        dao.put(model);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());
        
        return model;
    }
    
    /**
     * カテゴリの追加
     * @param category
     * @param name
     * @return
     */
    public static ArticleCategoryModel put(String name) {
        ArticleCategoryModel model = new ArticleCategoryModel();

        model.setName(name);
        model.setUpdateDate(new Date());
        
        return put(model);
    }
    
    /**
     * カテゴリの削除
     * @param category
     * @return
     */
    public static void deleteCategory(Long categoryId) {
        dao.delete(createKey(categoryId));
        
    }
    
    /**
     * キーの作成
     * @param articleModel
     * @param lang
     * @return
     */
    private static Key createKey(Long id) {
        return Datastore.createKey(ArticleCategoryModelMeta.get(), id);
    }

}
