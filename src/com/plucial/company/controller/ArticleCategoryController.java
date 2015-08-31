package com.plucial.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.ArticleModel;
import com.plucial.company.service.ArticleCategoryService;
import com.plucial.company.service.ArticleService;

public class ArticleCategoryController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        String categoryId = asString("categoryId");
        
        // カテゴリの取得
        ArticleCategoryModel categoryModel = ArticleCategoryService.get(Long.valueOf(categoryId));
        
        if(categoryModel == null) redirect("/");
        
        // 記事リストの取得
        List<ArticleModel> articletList = ArticleService.getArticleListByCategory(20, categoryModel, null);
        
        // リクエストスコープの設定
        requestScope("categoryModel", categoryModel);
        requestScope("articletList", articletList == null ? new ArrayList<ArticleModel>() : articletList);
        requestScope("pageTitle", categoryModel.getName());
        
        return forward("articleCategory.jsp");
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
