package com.plucial.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.datanucleus.util.StringUtils;
import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.model.ArticleModel;
import com.plucial.company.service.ArticleService;

public class IndexController extends BaseController {

    /**
     * ベース言語処理
     */
    @Override
    protected Navigation execute() throws Exception {
        
        // /ja/ → / にリダイレクト
        if(!StringUtils.isEmpty(asString("lang"))) {
            return redirect("/");
        }
        
        // 新着
        List<ArticleModel> articletList = ArticleService.getNewArticleList(null, 10, null);
        
        // リクエストスコープの設定
        requestScope("articletList", articletList == null ? new ArrayList<ArticleModel>() : articletList);
        
        
        return forward("index.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "Plucial,Inc.";
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_HOME;
    }
}
