package com.cigniti.test.dataproviders;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

public class DesiredCapabilitiesFromPropertyFileProvider implements DesiredCapabilitiesProvider{

    private String propertiesFileName = "appium-capabilities.properties";
    private Properties properties;

    public DesiredCapabilitiesFromPropertyFileProvider() throws IOException {
        loadProperties();
    }

    public DesiredCapabilitiesFromPropertyFileProvider(Properties properties) {
        this.properties = properties;
    }

    public DesiredCapabilities provide() throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        for(String key : properties.stringPropertyNames()) {
            capabilities.setCapability(key,properties.getProperty(key));
        }
        return capabilities;
    }

    private void loadProperties() throws IOException {

        properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName));
    }

}
