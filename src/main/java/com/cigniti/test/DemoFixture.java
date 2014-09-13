package com.cigniti.test;


import com.cigniti.test.dataproviders.DesiredCapabilitiesFromPropertyFileProvider;
import com.cigniti.test.dataproviders.DesiredCapabilitiesProvider;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class DemoFixture {

    private AppiumDriver driver;
    private DesiredCapabilitiesProvider cdp;
    private Logger logger = Logger.getLogger(this.getClass());

    public DemoFixture() throws IOException {
        cdp = new DesiredCapabilitiesFromPropertyFileProvider();
    }

    public DemoFixture(String attr) throws IOException {
        cdp = new DesiredCapabilitiesFromPropertyFileProvider();
    }

    public void initiate() throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        BasicConfigurator.configure();
        logger.info(capabilities.toString());
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cdp.provide());
        logger.info(capabilities.toString());
    }




}
