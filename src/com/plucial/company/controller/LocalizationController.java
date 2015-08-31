package com.plucial.company.controller;

import org.slim3.controller.Navigation;

public class LocalizationController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
//        // ターゲット言語
//        String lang = asString("lang");
//        // 対象コンテンツURLの取得
//        String baseURI = asString("baseURI");
//        
//        // -----------------------------------------------
//        // 他言語の場合
//        // -----------------------------------------------
//        if(!StringUtils.isEmpty(lang) && !lang.equals(Constants.BASE_LANG)) {
//            // 対象言語のモデルを取得
//            TranslateModel translateModel = TranslateService.getOtherTranslateModel(lang, requestURL);
//            
//            // 存在しない場合は、他言語モデルを再取得
//            if(translateModel == null) {
//                String source = null;
//                String translateHTML = null;
//
//                // WEBコンテンツの取得
//                try {
//                    source = Utils.getWebContent(request.getServerName(), baseURI);
//
//                } catch (Exception e) {
//                    return null;
//                }
//
//                // 翻訳処理
//                try {
//                    if(!lang.equals(Constants.BASE_LANG)) {
//                        translateHTML = Utils.translateHTML(source, lang);
//                    }
//
//                } catch (Exception e) {
//                }
//                
//                // 保存
//                translateModel = TranslateService.putOtherTranslate(lang, requestURL, translateHTML);
//                
//            }
//            
//            // 画面表示
//            requestScope("contents", translateModel.getContentString());
//            
//            return forward("localization.jsp");
//        }
//        
//
//        return forward(requestURL);
        
        return null;
    }

    @Override
    protected String getPageTitle() {
        return null;
    }

    @Override
    protected String getMainMenuSelect() {
        return null;
    }

    @Override
    protected Navigation executeOtherLang(String baseURI, String requestURL,
            String lang) throws Exception {
        return null;
    }
}
