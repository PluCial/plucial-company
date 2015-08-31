package com.plucial.company.controller.admin;

import java.net.URLEncoder;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.controller.BaseController;

public class LoginController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/oauth2callback");

        String oauthUrl = "https://accounts.google.com/o/oauth2/auth?scope="
                + URLEncoder.encode(Constants.GOOGLE_DRIVE_API_SCOPE + " " + Constants.GOOGLE_URLSHORTENER_API_SCOPE, "utf-8")
                + "&redirect_uri="
                + URLEncoder.encode(callbackURL.toString(), "utf-8")
                + "&response_type=code"
                + "&client_id="
                + Constants.GOOGLE_PROJECT_CLIENT_ID
                + "&approval_prompt=force"
                + "&access_type=offline";

        requestScope("oauthUrl", oauthUrl);
        
        
        return forward("login.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "管理画面ログイン";
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
