package com.plucial.company.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.datanucleus.util.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.TranslateTargetModel;
import com.plucial.company.model.TranslateModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleCategoryService;
import com.plucial.company.service.TranslateTargetService;
import com.plucial.company.service.SystemService;
import com.plucial.company.service.TranslateService;
import com.plucial.company.utils.Utils;

public abstract class BaseController extends Controller {

    @SuppressWarnings("rawtypes")
    @Override
    protected Navigation run() throws Exception {
        
        System.out.println("getServerName:" + request.getServerName());
        System.out.println("getRequestURI:" + request.getRequestURI());
        
        UserModel loginUserModel = getLoginUser();

        // リクエストスコープの設定
        requestScope("isLogin", String.valueOf(loginUserModel != null));
        requestScope("loginUserModel", loginUserModel);
        requestScope("isSmartPhone", String.valueOf(isSmartPhone()));
        requestScope("pageTitle", getPageTitle());
        requestScope("mainMenuSelect", getMainMenuSelect());
        
        // 記事カテゴリ
        List<ArticleCategoryModel> categoryList = ArticleCategoryService.getCategoryList();
        requestScope("categoryList", categoryList == null ? new ArrayList<ArticleCategoryModel>() : categoryList);
        
        // リクエストURL
        String parameterString = null;
        Map paramMap = request.getParameterMap();
        Iterator param = request.getParameterMap().keySet().iterator();
        while (param.hasNext()) {
            String key = (String)param.next(); 
            String par[]=(String[])paramMap.get(key); 

            if(parameterString == null) {
                parameterString = "?";
            }else {
                parameterString = parameterString + "&";
            }

            parameterString = parameterString + key + "=" + par[0];
        }

        // 言語
        String lang = asString("lang");
        // baseUri
        String baseURI = asString("baseURI");

        // 他言語の場合
        if(!StringUtils.isEmpty(lang) && !lang.equals(Constants.BASE_LANG)) {
            
            try {
                return executeOtherLang(baseURI, request.getRequestURI() + parameterString, lang);
                
            } catch (Exception e) {
                e.printStackTrace();
                // 問題起きた場合ベース言語を返す
                return execute();
            }
        }
        
        // ベース言語の場合
        return execute();
    }
    
    /**
     * 登録ユーザーの場合、登録情報を取得する。
     * 登録ユーザーではない、もしくGoogleアカウントにログインしていない場合は、
     * エラーを生成
     * @return
     * @throws Exception
     */
    public UserModel getLoginUser() {

        UserModel userModel = sessionScope("userModel");

        return userModel;
    }

    /**
     * デバイスがスマートフォンであるか判定
     * @param request
     * @return
     */
    protected boolean isSmartPhone() {

        if(request.getHeader("User-Agent") != null) {
            String userAgent = request.getHeader("User-Agent").toLowerCase();

            if(userAgent != null && (userAgent.indexOf("iphone") > 0 || userAgent.indexOf("android") > 0)) {
                return true;
            }
        }

        return false;
    }

    /**
     * リクエスト処理
     * @return
     * @throws Exception
     */
    protected abstract Navigation execute() throws Exception;
    
    /**
     * 他言語処理
     */
    protected Navigation executeOtherLang(String baseURI, String requestURL, String lang)
            throws Exception {
        
        // 対象コンテンツモデルを取得
        TranslateTargetModel targetModel = TranslateTargetService.get(baseURI);
        if(targetModel == null) {
            targetModel = TranslateTargetService.put(baseURI);
        }
        
        // 対象言語のモデルを取得
        TranslateModel translateModel = TranslateService.get(requestURL);
        
        String source = null;
        String translateHTML = null;
        
        // 存在しない場合は、他言語モデルを再取得
        if(translateModel == null 
                || targetModel.getUpdateDate().after(translateModel.getCreateDate())
                || SystemService.getSystemTranslateUpdateDate().after(translateModel.getCreateDate())) {

            // WEBコンテンツの取得
            source = Utils.getWebContent(request.getServerName(), baseURI);
            // 翻訳
            translateHTML = Utils.translateHTML(source, lang);
            // 保存
            translateModel = TranslateService.put(targetModel, lang, requestURL, translateHTML);
        }
        
        // 画面表示
        requestScope("contents", translateModel == null ? source :  translateModel.getContentString());
        
        return forward("/localization.jsp");
    }

    /**
     * ページタイトルの設定
     * @return
     * @throws Exception
     */
    protected abstract String getPageTitle();
    
    /**
     * ページURIを取得
     * @return
     * @throws Exception
     */
    protected abstract String getMainMenuSelect();

}
