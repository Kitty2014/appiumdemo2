package com.cigniti.test.dataproviders;

import java.io.IOException;
import java.net.URL;

public class ServerUrlProvider {

    public static URL provide() throws IOException {
        PropertiesLoader loader = new PropertiesLoader("common.properties");
        return new URL(loader.getProperty("appiumserver.url"));
    }

}
