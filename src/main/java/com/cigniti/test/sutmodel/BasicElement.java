package com.cigniti.test.sutmodel;

import java.util.Properties;

public class BasicElement {

    private BasicScreen parent;
    private Properties properties = new Properties();

    public BasicElement(String name, BasicScreen parent) {
        properties.setProperty("name", name);
        this.parent = parent;
        parent.withElement(this);
    }

    public String getName() {
        return properties.getProperty("name");
    }

    public BasicScreen getParent() {
        return parent;
    }

    public BasicElement withProperties(Properties prop) {
        properties.putAll(prop);
        return this;
    }

    public BasicElement withProperty(String name, String value) {
        properties.setProperty(name, value);
        return this;
    }

}
