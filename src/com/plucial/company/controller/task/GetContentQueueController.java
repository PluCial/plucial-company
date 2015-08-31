package com.plucial.company.controller.task;

import java.io.InputStream;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.appengine.api.datastore.Text;
import com.plucial.company.Constants;
import com.plucial.company.model.ArticleModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleService;
import com.plucial.company.utils.Utils;

public class GetContentQueueController extends Controller {
    
    private static final HttpTransport TRANSPORT = new NetHttpTransport();
    private static final JacksonFactory JSON_FACTORY = new JacksonFactory();
    
    private static final Logger logger = Logger.getLogger(GetContentQueueController.class.getName());

    @Override
    public Navigation run() throws Exception {
        
        String lang = asString("lang");
        if(lang == null || lang.length() <= 0) {
            lang = "ja";
        }
        ArticleModel articleModel = null;

        try{
            articleModel = getArticleModel();
            
        }catch(Exception e) {
            return null;
        };
        
        // タスクは成功するまで実行されるため、失敗時は例外をキャッチして再実行をさせない
        try{
            UserModel userModel = articleModel.getCreateUserModelRef().getModel();
            
            // トークン情報の作成
            GoogleCredential credential = new GoogleCredential.Builder()
            .setJsonFactory(JSON_FACTORY)
            .setTransport(TRANSPORT)
            .setClientSecrets(Constants.GOOGLE_PROJECT_CLIENT_ID, Constants.GOOGLE_PROJECT_CLIENT_SECRET).build()
            .setRefreshToken(userModel.getRefreshToken());

            // リフレッシュトークンを元にアクセストークンを更新
            credential.refreshToken();
            
            // ドライブサービスの生成
            Drive service = new Drive.Builder(new NetHttpTransport(), JSON_FACTORY, credential).build();
            
            // 対象のドライブファイルを取得
            File driveFile = service.files().get(articleModel.getDriveFileId()).execute();
            
            // ドキュメントのHTMLを取得
            HttpResponse resp =
                    service.getRequestFactory().buildGetRequest(new GenericUrl(driveFile.getExportLinks().get("text/html")))
                        .execute();
            InputStream stream = (InputStream) resp.getContent();
            
            // HTML パーサーの生成
            Document document = Jsoup.parse(stream, "utf-8", driveFile.getExportLinks().get("text/html"));
            
            // HTML の整形
            Utils.deleteWidthAndHeightStyle(document, "span");
            Utils.deleteWidthAndHeightStyle(document, "img");
            
            // ArticleLocation の登録
            String title =  driveFile.getTitle();
            String content = document.body().html();
            articleModel.setTitle(title);
            articleModel.setContent(new Text(content));
            
            // 記事情報の更新
            String style = Utils.changeCss(document);
            articleModel.setDocumentStyleSheet(new Text(style));
            articleModel.setPublicFlg(true);
            ArticleService.put(articleModel);
            
            
        }catch(Exception e) {
            logger.severe(e.toString());
        }
        
        return null;
    }
    
    public ArticleModel getArticleModel() throws Exception {

        String articleId = asString("articleId");
        
        if(articleId == null || articleId.isEmpty()) new Exception();

        ArticleModel model = ArticleService.get(Long.valueOf(articleId));
        
        if(model == null) throw new Exception();

        return model;
    }
}
