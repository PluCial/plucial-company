package com.plucial.company.controller.info;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.controller.BaseController;

public class ContactController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        
        return forward("contact.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "お問い合わせ";
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_CONTACT;
    }
}
