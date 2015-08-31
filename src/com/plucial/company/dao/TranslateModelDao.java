package com.plucial.company.dao;

import org.slim3.datastore.DaoBase;

import com.plucial.company.meta.TranslateModelMeta;
import com.plucial.company.model.TranslateModel;

public class TranslateModelDao extends DaoBase<TranslateModel> {
    
    /** Meta */
    TranslateModelMeta meta = TranslateModelMeta.get();
    
//    /**
//     * 記事ロケーションを取得
//     * @param articleModel
//     * @param lang
//     * @return
//     */
//    public TranslateModel getArticleTranslateModel(ArticleModel articleModel, String lang) {
//        
//        ModelRefAttributeMeta<TranslateModel, ModelRef<ArticleModel>, ArticleModel> refMeta = meta.articleModellRef;
//
//        return Datastore.query(meta)
//                .filter(
//                    refMeta.equal(articleModel.getKey()),
//                    meta.lang.equal(lang)
//                    )
//                .asSingle();
//    }
//    
//    /**
//     * カテゴリのロケーションを取得
//     * @param categoryModel
//     * @param lang
//     * @param url
//     * @return
//     */
//    public TranslateModel getCategoryTranslateModel(ArticleCategoryModel categoryModel, String lang, String url) {
//        
//        ModelRefAttributeMeta<TranslateModel, ModelRef<ArticleCategoryModel>, ArticleCategoryModel> refMeta = meta.articleCategoryModellRef;
//        
//        return Datastore.query(meta)
//                .filter(
//                    refMeta.equal(categoryModel.getKey()),
//                    meta.lang.equal(lang),
//                    meta.uri.equal(url)
//                    )
//                .asSingle(); 
//    }
//    
//    /**
//     * その他のロケーションを取得
//     * @param lang
//     * @param url
//     * @return
//     */
//    public TranslateModel getOtherTranslateModel(String lang, String url) {
//
//        return Datastore.query(meta)
//                .filter(
//                    meta.lang.equal(lang),
//                    meta.uri.equal(url)
//                    )
//                .asSingle();
//    }

}
