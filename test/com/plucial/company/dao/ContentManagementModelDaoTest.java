package com.plucial.company.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ContentManagementModelDaoTest extends AppEngineTestCase {

    private TranslateTargetModelDao dao = new TranslateTargetModelDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
