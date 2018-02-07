package com.codecool;

public class SingleValue extends Value {

    private String param;

    public SingleValue(String param, boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }
}
