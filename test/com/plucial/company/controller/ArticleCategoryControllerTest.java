package com.plucial.company.controller;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ArticleCategoryControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/articleCategory");
        ArticleCategoryController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/articleCategory.jsp"));
    }
}
