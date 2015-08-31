package com.plucial.company.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.Sort;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.plucial.company.meta.ArticleModelMeta;

@Model(schemaVersion = 1)
public class ArticleCategoryModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * String Key
     */
    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    /**
     * カテゴリ名
     */
    private String name;
    
    /**
     * 表示順
     */
    private int index = 0;
    
    @Attribute(unindexed = true)
    private Date updateDate;
    
    /** 作成した ArticleModelとの関連 */
    @Attribute(persistent = false)
    private InverseModelListRef<ArticleModel, ArticleCategoryModel> articleModelListRef =
            new InverseModelListRef<ArticleModel, ArticleCategoryModel>(
                    ArticleModel.class,
                    ArticleModelMeta.get().categoryModelRef.getName(),
                    this,
                    new Sort(ArticleModelMeta.get().createDate, SortDirection.DESCENDING));

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ArticleCategoryModel other = (ArticleCategoryModel) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public InverseModelListRef<ArticleModel, ArticleCategoryModel> getArticleModelListRef() {
        return articleModelListRef;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
