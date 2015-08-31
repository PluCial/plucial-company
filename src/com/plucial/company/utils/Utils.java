package com.plucial.company.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.translate.Translate;
import com.google.api.services.translate.TranslateRequestInitializer;
import com.google.api.services.translate.model.TranslationsListResponse;
import com.google.api.services.translate.model.TranslationsResource;
import com.plucial.company.Constants;

public class Utils {
    
    /**
     * HTML内の絶対サイズ指定を削除
     * @param document
     * @param tagType
     */
    public static void deleteWidthAndHeightStyle(Document document, String tagType) {
        Elements tagElements = document.getElementsByTag(tagType);
        
        for(Element element : tagElements) {
            Attributes attributes = element.attributes();
            
            for(Attribute attribute: attributes) {
                if(attribute.getKey().equals("style")){
                    // スタイル要素リスト
                    String[] items = attribute.getValue().trim().split(";");
                    String newValue = "";
                    for(String item: items){

                        if(!item.contains("width:") && !item.contains("height:")){
                            newValue = newValue.concat(item).concat(";");
                        }
                    }
                    
                    attribute.setValue(newValue);
                }
            }
        }
    }
    
    /**
     * CSSの変更
     * @param document
     * @return
     */
    public static String changeCss(Document document) {
        
        Elements tagElements = document.getElementsByTag("style");
        Element styleElement = tagElements.get(0);
        String style = styleElement.data();
        String newStyles = "";
        
        String[] items = style.split("}");
        for(String item: items) {
            
            String[] tmp =  item.split("\\{");
            String propertyKey = tmp[0];
            String propertyAllStyle = tmp[1];
            
            String[] propertys = propertyAllStyle.split(";");
            
            String elmStyle = propertyKey + "{";
            
            for(String property: propertys) {
                if(property.trim().toLowerCase().indexOf("font-size") < 0 && property.trim().toLowerCase().indexOf("font-family") < 0) {
                    elmStyle = elmStyle + property + ";";
                }
            }
            
            newStyles = newStyles + "#article-content " + elmStyle + "}";
        }
        
        return newStyles + "#article-content img{max-width:90%;border:1px #aaa solid;box-shadow:2px 2px 2px 2px #aaa;}#article-content h2{font-size: 1.3em;margin-top:2.5em;margin-bottom:0.5em;padding: 18px 0;border-top: 1px solid #000;border-bottom: 1px solid #000;}#article-content h3{padding: 10px 0 10px 10px;border-left: 5px solid #555;margin-top: 1em;margin-bottom: 0.5em;}";
    }
    
    
    /**
     * WEBコンテンツの取得
     * @param url
     * @return
     * @throws Exception
     */
    public static String getWebContent(String url) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;


        // 対象コンテンツの取得
        URL urlPathtraq = new URL(url);
        reader = new BufferedReader(new InputStreamReader(urlPathtraq.openStream(), "UTF-8"));

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        
        return sb.toString();
    }
    
    /**
     * WEBコンテンツの取得
     * @param serverName
     * @param path
     * @return
     * @throws Exception
     */
    public static String getWebContent(String serverName, String path) throws Exception {
        String domain = serverName;
        if(serverName.indexOf("localhost") >= 0) domain = "localhost:8888";
       
        String requestURL = "http://" + domain + path;
        
        System.out.println(requestURL);
        
        return getWebContent(requestURL);
    }
    
    /**
     * HTML 翻訳
     * @param source
     * @param targetLang
     * @return
     */
    public static String translateHTML(String source, String targetLang) {
        
        String contents = null;
        
        System.out.println("targetLang:" + targetLang);
        System.out.println(source);
        
        try {
            // 翻訳Translate の生成
            Translate translate = new Translate.Builder(new NetHttpTransport(), new JacksonFactory(), null)
            .setGoogleClientRequestInitializer(new TranslateRequestInitializer(Constants.PUBLIC_API_KEY))
            .setApplicationName(Constants.GOOGLE_APPLICATION_NAME)
            .build();
            

            List<String> qList = new ArrayList<String>();
            qList.add(source);
            TranslationsListResponse response = translate.translations()
                    .list(qList, targetLang)
                    .setSource(Constants.BASE_LANG)
                    .setFormat("html")
                    .execute();
            List<TranslationsResource> resourceList = response.getTranslations();
            TranslationsResource resource = resourceList.get(0);
            
            System.out.println("response:" + response.toString());

            contents = resource.getTranslatedText();

            contents = contents.replace("/" + Constants.BASE_LANG + "/", "/" + targetLang + "/");

        } catch (Exception e) {
            e.printStackTrace();
            
            return source;
            
        }
        
        return contents;
    }

}
