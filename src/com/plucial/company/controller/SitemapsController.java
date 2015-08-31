package com.plucial.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.service.ArticleCategoryService;

public class SitemapsController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        List<ArticleCategoryModel> caetgoryList = ArticleCategoryService.getCategoryList();
        
        // リクエストスコープの設定
        requestScope("caetgoryList", caetgoryList == null ? new ArrayList<ArticleCategoryModel>() : caetgoryList);
        
        return forward("sitemaps.jsp");
    }
}
