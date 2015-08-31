package com.plucial.company.service;

import java.util.Date;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.plucial.company.Constants;
import com.plucial.company.dao.SystemModelDao;
import com.plucial.company.meta.SystemModelMeta;
import com.plucial.company.model.SystemModel;


public class SystemService {
    
    private static SystemModelDao dao = new SystemModelDao();
    
    /**
     * IDから記事を取得
     * @param id
     * @return
     */
    public static SystemModel getByKey(String propertyKey) {
        Key key = createKey(propertyKey);
        SystemModel model = Memcache.get(key.toString());
        if(model != null) return model;

        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * システム翻訳更新日を取得
     * @return
     */
    public static Date getSystemTranslateUpdateDate() {
        return getByKey(Constants.SYSTEM_TRANSLATE_UPDATE_DATE_PROPERTY_KEY).getUpdateDate();
    }
    
    /**
     * PUT
     * @param model
     * @return
     */
    public static SystemModel put(SystemModel model) {
        // 永久化
        dao.put(model);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());

        return model;
    }
    
    /**
     * PUT
     * @param propertyKey
     * @param value
     * @return
     */
    public static SystemModel put(String propertyKey, String value) {
        
        SystemModel model = new SystemModel();
        model.setKey(createKey(propertyKey));
        model.setValue(value);
        model.setUpdateDate(new Date());
        
        return put(model);
    }
    
    /**
     * キーの作成
     * @param articleModel
     * @param lang
     * @return
     */
    private static Key createKey(String propertyKey) {
        return Datastore.createKey(SystemModelMeta.get(), propertyKey);
    }

}
