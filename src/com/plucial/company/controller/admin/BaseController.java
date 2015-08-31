package com.plucial.company.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.SystemModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleCategoryService;
import com.plucial.company.service.SystemService;

public abstract class BaseController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        
        try {
            UserModel loginUserModel = getLoginUser();
            
            initialization();

            requestScope("isLogin", String.valueOf(loginUserModel != null));
            requestScope("loginUserModel", loginUserModel);
            
            requestScope("isSmartPhone", String.valueOf(isSmartPhone()));

            requestScope("pageTitle", getPageTitle());
            
            // 記事カテゴリ
            List<ArticleCategoryModel> categoryList = ArticleCategoryService.getCategoryList();
            requestScope("categoryList", categoryList == null ? new ArrayList<ArticleCategoryModel>() : categoryList);
            
            // ログインしていない場合
            return execute(loginUserModel);

        }catch(Exception e) {
            e.printStackTrace();
            return redirect("/");
        }
    }
    
    /**
     * 登録ユーザーの場合、登録情報を取得する。
     * 登録ユーザーではない、もしくGoogleアカウントにログインしていない場合は、
     * エラーを生成
     * @return
     * @throws Exception
     */
    public UserModel getLoginUser() throws Exception {

        UserModel userModel = sessionScope("userModel");

        if(userModel == null) throw new Exception();

        return userModel;
    }

    /**
     * デバイスがスマートフォンであるか判定
     * @param request
     * @return
     */
    protected boolean isSmartPhone() {

        String userAgent = request.getHeader("User-Agent").toLowerCase();

        if(userAgent != null && (userAgent.indexOf("iphone") > 0 || userAgent.indexOf("android") > 0)) {
            return true;
        }

        return false;
    }
    
    /**
     * システム初期化
     */
    protected void initialization() {
        SystemModel updateDateModel = SystemService.getByKey(Constants.SYSTEM_TRANSLATE_UPDATE_DATE_PROPERTY_KEY);
        
        if(updateDateModel == null) {
            SystemService.put(Constants.SYSTEM_TRANSLATE_UPDATE_DATE_PROPERTY_KEY, "System Translate Update Date");
        }
    }

    /**
     * リクエスト処理
     * @return
     * @throws Exception
     */
    protected abstract Navigation execute(UserModel loginUserModel) throws Exception;

    /**
     * ページタイトルの設定
     * @return
     * @throws Exception
     */
    protected abstract String getPageTitle();

}
