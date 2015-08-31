package com.plucial.company.dao;

import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Sort;

import com.google.appengine.api.datastore.Query.SortDirection;
import com.plucial.company.meta.ArticleCategoryModelMeta;
import com.plucial.company.model.ArticleCategoryModel;

public class ArticleCategoryModelDao extends DaoBase<ArticleCategoryModel>{
    
    /** Meta */
    ArticleCategoryModelMeta meta = ArticleCategoryModelMeta.get();
    
    /**
     * カテゴリリストの取得
     * @return
     */
    public List<ArticleCategoryModel> getCategoryList() {
        
        return Datastore.query(meta)
                .sort(new Sort(meta.index, SortDirection.ASCENDING))
                .asList();
    }

}
