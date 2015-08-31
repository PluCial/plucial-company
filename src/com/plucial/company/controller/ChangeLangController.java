package com.plucial.company.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class ChangeLangController extends Controller {

    @Override
    public Navigation run() throws Exception {
        
        String lang = asString("lang");
        String baseURI = asString("baseURI");
        
        return redirect("/" + lang + baseURI);
    }
}
