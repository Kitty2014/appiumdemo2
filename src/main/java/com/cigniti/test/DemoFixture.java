package com.cigniti.test;

import static com.cigniti.test.dataproviders.DesiredCapabilitiesProviderFactory.getCapabilitiesProvider;

import com.cigniti.test.dataproviders.ServerUrlProvider;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;

public class DemoFixture {

    private RemoteWebDriver driver;

    public void initiateSession() throws IOException {
        driver = new AppiumDriver( ServerUrlProvider.provide(), getCapabilitiesProvider().provide());
    }

    public void cleanupSession() {
        driver.quit();
    }




}
