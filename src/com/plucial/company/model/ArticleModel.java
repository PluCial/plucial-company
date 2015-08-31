package com.plucial.company.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class ArticleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    /** ドライブファイルID */
    private String driveFileId;
    
    /**
     * タイトル
     */
    @Attribute(unindexed = true)
    private String title;
    
    /**
     * コンテンツ
     */
    @Attribute(unindexed = true)
    private Text content;
    
    /** 公開フラグ */
    private boolean publicFlg = false;
    
    /** ドキュメントのスタイルシート */
    @Attribute(unindexed = true)
    private Text documentStyleSheet;
    
    /** 作成日時(システム入力) */
    private Date updateDate;
    
    /** 作成日時(システム入力) */
    private Date createDate;
    
    /** カテゴリオブジェクト(永久化しない) */
    @Attribute(persistent = false)
    private ArticleCategoryModel articleCategoryModel;
    
    // ----------------------------------------------------------------------
    // 関連
    // ----------------------------------------------------------------------
    /** 作成者のUserModel に対しての関連 */
    private ModelRef<UserModel> createUserModelRef = new ModelRef<UserModel>(UserModel.class);
    
    /** カテゴリ に対しての関連 */
    private ModelRef<ArticleCategoryModel> categoryModelRef = new ModelRef<ArticleCategoryModel>(ArticleCategoryModel.class);

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
        ArticleModel other = (ArticleModel) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getDriveFileId() {
        return driveFileId;
    }

    public void setDriveFileId(String driveFileId) {
        this.driveFileId = driveFileId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isPublicFlg() {
        return publicFlg;
    }

    public void setPublicFlg(boolean publicFlg) {
        this.publicFlg = publicFlg;
    }
    
    public ModelRef<UserModel> getCreateUserModelRef() {
        return createUserModelRef;
    }
    
//    public InverseModelListRef<TranslateModel, ArticleModel> getTranslateModelListRef() {
//        return translateModelListRef;
//    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Text getDocumentStyleSheet() {
        return documentStyleSheet;
    }

    public void setDocumentStyleSheet(Text documentStyleSheet) {
        this.documentStyleSheet = documentStyleSheet;
    }
    
    public String getDocumentStyleSheetString() {
        if (documentStyleSheet == null) {
            return null;
        }
        return documentStyleSheet.getValue();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Text getContent() {
        return content;
    }

    public void setContent(Text content) {
        this.content = content;
    }
    
    public String getContentString() {
        if (content == null) {
            return null;
        }
        return content.getValue();
    }

    public ModelRef<ArticleCategoryModel> getCategoryModelRef() {
        return categoryModelRef;
    }

    public ArticleCategoryModel getArticleCategoryModel() {
        return articleCategoryModel;
    }

    public void setArticleCategoryModel(ArticleCategoryModel articleCategoryModel) {
        this.articleCategoryModel = articleCategoryModel;
    }
}
