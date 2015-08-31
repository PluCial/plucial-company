package com.plucial.company.controller.admin;

import java.util.Date;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.model.SystemModel;
import com.plucial.company.model.UserModel;
import com.plucial.company.service.SystemService;

public class TranslateResetAllController extends BaseController {

    @Override
    protected Navigation execute(UserModel loginUserModel) throws Exception {
        
        SystemModel systemModel = SystemService.getByKey(Constants.SYSTEM_TRANSLATE_UPDATE_DATE_PROPERTY_KEY);
        systemModel.setUpdateDate(new Date());
        
        SystemService.put(systemModel);
        
        return redirect("/admin/setting");
    }

    @Override
    protected String getPageTitle() {
        return null;
    }
}
