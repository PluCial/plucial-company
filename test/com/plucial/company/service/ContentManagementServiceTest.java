package com.plucial.company.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ContentManagementServiceTest extends AppEngineTestCase {

    private TranslateTargetService service = new TranslateTargetService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
