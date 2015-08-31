package com.plucial.company.controller;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.model.ArticleModel;
import com.plucial.company.service.ArticleService;

public class ArticleController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        // 記事ID
        String id = asString("id");
        
        // 対象記事の取得
        ArticleModel articleModel = ArticleService.get(Long.valueOf(id));
        if(articleModel == null) redirect("/");
        
        // リクエストスコープ
        requestScope("pageTitle", articleModel.getTitle());
        requestScope("articleModel", articleModel);

        return forward("article.jsp");
    }

    @Override
    protected String getPageTitle() {
        return null;
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_BLOG;
    }
}
