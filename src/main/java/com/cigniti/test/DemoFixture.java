package com.cigniti.test;

import com.cigniti.test.appiumsession.TestsExecutionContext;
import com.cigniti.test.sutmodel.ApplicationModel;
import com.cigniti.test.sutmodel.ApplicationModelFactory;

public class DemoFixture {

    private static TestsExecutionContext context = new TestsExecutionContext();
    private static ApplicationModel model;

    public DemoFixture(String applicationName, String platformName) {
        context.setApplicationName(applicationName);
        context.setPlatformName(platformName);
        setApplicationModel();
    }

    private void setApplicationModel() {
        model = ApplicationModelFactory.getModel(context);
    }
}
