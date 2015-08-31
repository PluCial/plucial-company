package com.plucial.company.dao;

import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.plucial.company.meta.TranslateTargetModelMeta;
import com.plucial.company.model.TranslateTargetModel;

public class TranslateTargetModelDao extends DaoBase<TranslateTargetModel>{
    
    /** Meta */
    TranslateTargetModelMeta meta = TranslateTargetModelMeta.get();
    
    /**
     * カテゴリリストの取得
     * @return
     */
    public List<TranslateTargetModel> getTargetList() {
        
        return Datastore.query(meta).asList();
    }

}
