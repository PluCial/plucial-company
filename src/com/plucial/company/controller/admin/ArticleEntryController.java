package com.plucial.company.controller.admin;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.controller.validator.Validators;

import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions.Builder;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;
import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.ArticleModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleCategoryService;
import com.plucial.company.service.ArticleService;

public class ArticleEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel userModel) throws Exception {

            // 入力チェック
            if (!isPost() || !createValidate(userModel)) {
                return forward("/admin/addArticle");
            }

            String category = asString("category");
            String driveFileId = asString("driveFileId");
            
            ArticleModel articleModel = ArticleService.getArticleByDriveFileId(driveFileId);
            ArticleCategoryModel categoryModel = ArticleCategoryService.get(Long.valueOf(category));
            
            // 新規
            if(articleModel == null) {
                articleModel = ArticleService.put(userModel, categoryModel, driveFileId);
            
            // 更新
            }else {
                articleModel.getCategoryModelRef().setModel(categoryModel);
                ArticleService.put(articleModel);
                
            }
            
            // アイキャッチの追加
            System.out.println("gcs start");
            addEyeCatchToGCS(articleModel);
            
            // タスクの開始
            Queue queue = QueueFactory.getQueue("get-content-queue");
            queue.add(Builder.withUrl("/task/getContentQueue").param("articleId", String.valueOf(articleModel.getKey().getId())));
            
            return redirect("/admin/addArticle");
    }

    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate(UserModel userModel) {
        Validators v = new Validators(request);
        
        // カテゴリ
        v.add("category", v.required());
        
        // GoogleドキュメントID
        v.add("driveFileId", v.required());
        
        // アイキャッチ画像
//        v.add("eyeCatch", v.required());
        
        return v.validate();
    }
    
    /**
     * GCS ファイルアップロード
     * @param articleModel
     * @throws IOException
     */
    private void addEyeCatchToGCS(ArticleModel articleModel) throws IOException {

        FileItem fileItem = requestScope("eyeCatch");
        
        // アップロードファイルない場合
        if(fileItem == null || fileItem.getData() == null || !fileItem.getContentType().startsWith("image")) {
            return;
        }

        GcsService gcsService =
                GcsServiceFactory.createGcsService(RetryParams.getDefaultInstance());

        GcsOutputChannel outputChannel = gcsService.createOrReplace(
            new GcsFilename(
                AppIdentityServiceFactory.getAppIdentityService().getDefaultGcsBucketName(), 
                String.valueOf("eye-catch/" + articleModel.getKey().getId())
                    ), 
            new GcsFileOptions.Builder()
            .mimeType(fileItem.getContentType())
            .acl("public-read")
            .build()
                );

        outputChannel.write(ByteBuffer.wrap(fileItem.getData()));

        outputChannel.close();
    }
    
    @Override
    protected String getPageTitle() {
        return "null";
    }
}
