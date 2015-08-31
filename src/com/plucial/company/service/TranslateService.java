package com.plucial.company.service;

import java.util.Date;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.plucial.company.dao.TranslateModelDao;
import com.plucial.company.meta.TranslateModelMeta;
import com.plucial.company.model.TranslateModel;
import com.plucial.company.model.TranslateTargetModel;


public class TranslateService {
    
    private static TranslateModelDao dao = new TranslateModelDao();
    
    /**
     * 取得
     * @param requestURL
     * @return
     */
    public static TranslateModel get(String requestURL) {
        
        Key key = createKey(requestURL);
        TranslateModel model = Memcache.get(key.toString());
        if(model != null) return model;
        
        model = dao.getOrNull(key);
        if(model != null) Memcache.put(model.getKey().toString(), model);

        return model;
    }
    
    /**
     * 他言語記事モデル登録
     * @param articleModel
     * @param lang
     * @param content
     * @return
     */
    public static TranslateModel put(TranslateModel model) {
        
        dao.put(model);
        
        // 自信のキャッシュをクリア
        Memcache.delete(model.getKey().toString());
        
        return model;
    }
    
    /**
     * 他言語記事モデル登録
     * @param articleModel
     * @param lang
     * @param content
     * @return
     */
    public static TranslateModel put(
            TranslateTargetModel targetModel,
            String lang, 
            String requestURL,
            String content) {
        
        TranslateModel model = new TranslateModel();
        model.setKey(createKey(requestURL));
        model.setLang(lang);
        model.setContent(new Text(content));
        model.setCreateDate(new Date());
        
        model.getTargetModellRef().setModel(targetModel);
        
        return put(model);
    }
    
    /**
     * キーの作成
     * @param keyString
     * @return
     */
    private static Key createKey(String keyString) {
        return Datastore.createKey(TranslateModelMeta.get(), keyString);
    }

}
