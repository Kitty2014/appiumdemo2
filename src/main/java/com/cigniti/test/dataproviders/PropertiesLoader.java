package com.cigniti.test.dataproviders;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    protected Properties properties;
    protected String propertiesFileName;

    public PropertiesLoader(String propertiesFileName) throws IOException {
        this.propertiesFileName = propertiesFileName;
        loadProperties();
    }

    public String getProperty(String key) throws IOException {

        return properties.getProperty(key);
    }

    private void loadProperties() throws IOException {

        properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName));
    }

}
