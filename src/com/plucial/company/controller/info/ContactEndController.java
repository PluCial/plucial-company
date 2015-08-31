package com.plucial.company.controller.info;

import org.slim3.controller.Navigation;

import com.plucial.company.Constants;
import com.plucial.company.controller.BaseController;

public class ContactEndController extends BaseController {

    @Override
    protected Navigation execute() throws Exception {
        return forward("contactEnd.jsp");
    }

    @Override
    protected String getPageTitle() {
        return "お問い合わせありがとうございました。";
    }

    @Override
    protected String getMainMenuSelect() {
        return Constants.MAIN_MENU_SELECT_CONTACT;
    }
}
