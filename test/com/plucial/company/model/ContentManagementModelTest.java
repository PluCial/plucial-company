package com.plucial.company.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ContentManagementModelTest extends AppEngineTestCase {

    private TranslateTargetModel model = new TranslateTargetModel();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
