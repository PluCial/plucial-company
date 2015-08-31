package com.plucial.company.dao;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.plucial.company.meta.UserModelMeta;
import com.plucial.company.model.UserModel;

public class UserModelDao extends DaoBase<UserModel>{
    
    /** UserModel Meta */
    UserModelMeta meta = UserModelMeta.get();
    
    /**
     * Email からユーザーモデルを取得
     * @param twitterUserId
     * @return
     */
    public UserModel getUserModelByEmail(String email) {
        return Datastore.query(meta)
                .filter(meta.email.equal(email))
                .asSingle();
    }

}
