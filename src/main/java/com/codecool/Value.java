package com.codecool;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {

    List<String> listString;

    public Value() {
    }

    public List<String> getInputPattern() {
        listString = new ArrayList<>();
        return listString;
    }

    public boolean getSelectionType() {
        return true;
    }
}
