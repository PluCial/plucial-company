package com.plucial.company.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Navigation;

import com.plucial.company.model.ArticleCategoryModel;
import com.plucial.company.model.TranslateTargetModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.TranslateTargetService;

public class SettingController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        List<TranslateTargetModel> targetList = TranslateTargetService.getTargetList();
        
        requestScope("targetList", targetList == null ? new ArrayList<ArticleCategoryModel>() : targetList);
        
        return forward("setting.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "システム設定";
    }
}
