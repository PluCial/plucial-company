package com.plucial.company.controller.admin;

import java.util.Date;

import org.slim3.controller.Navigation;

import com.plucial.company.model.TranslateTargetModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.TranslateTargetService;

public class TranslateResetEntryController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        String url = asString("url");
        TranslateTargetModel model = TranslateTargetService.get(url);
        model.setUpdateDate(new Date());
        TranslateTargetService.put(model);
        
        return redirect("/admin/setting");
    }

    @Override
    protected String getPageTitle() {
        return null;
    }
}
