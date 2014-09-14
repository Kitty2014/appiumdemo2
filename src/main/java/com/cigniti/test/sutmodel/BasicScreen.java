package com.cigniti.test.sutmodel;

import java.util.HashMap;

public class BasicScreen {
    private String name;
    private HashMap<String, BasicElement> elements = new HashMap<String, BasicElement>();

    public BasicScreen(String name) {
        this.name = name;
    }

    public BasicScreen withElement(BasicElement element) {
        elements.put(element.getName(), element);
        return this;
    }

}
