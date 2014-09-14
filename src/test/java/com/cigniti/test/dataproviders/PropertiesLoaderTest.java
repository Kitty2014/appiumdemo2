package com.cigniti.test.dataproviders;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PropertiesLoaderTest {

    SystemPropertiesLoader pl;

    @Test
    @Ignore
    public void shouldAppendCustomPropertiesIfFound() throws IOException {
        pl = new SystemPropertiesLoader("appium-capabilities.properties");

        assertEquals("19", pl.getProperty("platformVersion"));
        assertEquals("/home/toshiba/workspace/appium/com.ebay.mobile.apk", pl.getProperty("app"));
        assertEquals("Android", pl.getProperty("platformName"));
        assertEquals("android19", pl.getProperty("deviceName"));
        assertEquals("com.wunderkinder.wunderlistandroid", pl.getProperty("appPackage"));
        assertEquals(".Wunderlist", pl.getProperty("appActivity"));
    }
}
