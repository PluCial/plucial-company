package com.plucial.company.controller.admin;

import org.slim3.controller.Navigation;

import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleCategoryService;

public class CategoryDeleteEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String categoryId = asString("id");
        ArticleCategoryService.deleteCategory(Long.valueOf(categoryId));
        
        return redirect("/admin/category");
    }

    @Override
    protected String getPageTitle() {
        return null;
    }
}
