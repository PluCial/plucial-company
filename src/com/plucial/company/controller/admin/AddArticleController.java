package com.plucial.company.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleCategoryService;

public class AddArticleController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        List<ArticleCategoryModel> categoryList = ArticleCategoryService.getCategoryList();
        requestScope("categoryList", categoryList == null ? new ArrayList<ArticleCategoryModel>() : categoryList);
        
        return forward("addArticle.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "記事の追加";
    }
}
