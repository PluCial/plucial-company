package com.plucial.company.service;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.plucial.company.dao.TranslateTargetModelDao;
import com.plucial.company.meta.TranslateTargetModelMeta;
import com.plucial.company.model.TranslateTargetModel;


public class TranslateTargetService {
    
    private static TranslateTargetModelDao dao = new TranslateTargetModelDao();
    
    /**
     * キーから取得
     * @param keyString
     * @return
     */
    public static TranslateTargetModel get(String baseURI) {
        Key key = createKey(baseURI);
        TranslateTargetModel model = Memcache.get(key.toString());
        if(model != null) return model;
        
        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * コンテンツリストの作成
     * @return
     */
    public static List<TranslateTargetModel> getTargetList() {
        return dao.getTargetList();
    }
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static TranslateTargetModel put(TranslateTargetModel model) {
        
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
    public static TranslateTargetModel put(String baseURI) {
        TranslateTargetModel model = new TranslateTargetModel();

        model.setKey(createKey(baseURI));
        model.setUpdateDate(new Date());
        
        return put(model);
    }
    
    /**
     * キーの作成
     * @param keyString
     * @return
     */
    private static Key createKey(String keyString) {
        return Datastore.createKey(TranslateTargetModelMeta.get(), keyString);
    }

}
