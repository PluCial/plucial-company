package com.plucial.company.controller.admin;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.ArticleCategoryService;

public class CategoryEditEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String categoryId = asString("categoryId");
        String categoryName = asString("categoryName");
        
        // 入力チェック
        if (isPost() && createValidate()) {
            
            ArticleCategoryModel categoryModel = ArticleCategoryService.get(Long.valueOf(categoryId));
            categoryModel.setName(categoryName);
            
            ArticleCategoryService.put(categoryModel);
            
        }
        
        return redirect("/admin/category");
    }
    
    /**
     * バリデーション
     * @param userModel
     * @return
     */
    private boolean createValidate() {
        Validators v = new Validators(request);
        
        // カテゴリ
        v.add("categoryId", v.required());
        // カテゴリ
        v.add("categoryName", v.required());
        
        return v.validate();
    }

    @Override
    protected String getPageTitle() {
        return null;
    }
}
