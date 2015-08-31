package com.plucial.company.dao;

import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.S3QueryResultList;
import org.slim3.datastore.Sort;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Query.SortDirection;
import com.plucial.company.meta.ArticleModelMeta;
import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.ArticleModel;

public class ArticleModelDao extends DaoBase<ArticleModel> {
    
    /** 記事Meta */
    ArticleModelMeta meta = ArticleModelMeta.get();
    
    /**
     * ドキュメントIDから記事を取得
     * @param id
     * @return
     */
    public ArticleModel getArticleByDriveFileId(String driveFileId) {
        
        return Datastore.query(meta)
                .filter(meta.driveFileId.equal(driveFileId))
                .asSingle();
    }
    
    /**
     * 新しい記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public S3QueryResultList<ArticleModel> getNewArticleList(int num) {

        S3QueryResultList<ArticleModel> list = Datastore.query(meta)
                .filter(meta.publicFlg.equal(true))
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .limit(num)
                .asQueryResultList();

        return list;
    }
    
    /**
     * 新しい記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public S3QueryResultList<ArticleModel> getNewArticleList(int num, String cursor) {
        
        if (StringUtil.isEmpty(cursor)) return getNewArticleList(num);

        S3QueryResultList<ArticleModel> list = Datastore.query(meta)
                .filter(meta.publicFlg.equal(true))
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .encodedStartCursor(cursor)
                .limit(num)
                .asQueryResultList();

        return list;
    }
    
    /**
     * カテゴリの記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public S3QueryResultList<ArticleModel> getArticleListByCategory(int num, ArticleCategoryModel categoryModel) {

        S3QueryResultList<ArticleModel> list = Datastore.query(meta)
                .filter(
                    meta.categoryModelRef.equal(categoryModel.getKey()),
                    meta.publicFlg.equal(true)
                )
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .limit(num)
                .asQueryResultList();

        return list;
    }
    
    /**
     * カテゴリの記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public S3QueryResultList<ArticleModel> getArticleListByCategory(int num, ArticleCategoryModel categoryModel, String cursor) {
        
        if (StringUtil.isEmpty(cursor)) return getArticleListByCategory(num, categoryModel);

        S3QueryResultList<ArticleModel> list = Datastore.query(meta)
                .filter(
                    meta.categoryModelRef.equal(categoryModel.getKey()),
                    meta.publicFlg.equal(true)
                    )
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .encodedStartCursor(cursor)
                .limit(num)
                .asQueryResultList();

        return list;
    }
    
    /**
     * カテゴリの記事一覧を取得(新しい順)
     * @param userModel
     * @param num
     * @return
     */
    public List<ArticleModel> getArticleListByCategory(ArticleCategoryModel categoryModel) {

        List<ArticleModel> list = Datastore.query(meta)
                .filter(
                    meta.categoryModelRef.equal(categoryModel.getKey()),
                    meta.publicFlg.equal(true)
                    )
                .sort(new Sort(meta.createDate, SortDirection.DESCENDING))
                .asList();

        return list;
    }

}
