package com.plucial.company.controller.info;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.controller.BaseController;

public class DevelopmentController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        return forward("development.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "システム開発";
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_DEVELOPMENT;
    }
}
