package com.plucial.company.controller.info;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.controller.BaseController;

public class AboutController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        return forward("about.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "会社情報";
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_ABOUT;
    }
}
