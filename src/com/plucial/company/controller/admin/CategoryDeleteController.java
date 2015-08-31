package com.plucial.company.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleCategoryService;

public class CategoryDeleteController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String categoryId = asString("id");
        
        ArticleCategoryModel model = ArticleCategoryService.get(Long.valueOf(categoryId));
        
        requestScope("categoryModel", model);
        
        return forward("category_delete.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "カテゴリ削除";
    }
}
