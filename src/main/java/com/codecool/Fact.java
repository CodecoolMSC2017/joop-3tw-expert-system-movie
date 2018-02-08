package com.codecool;

import java.util.HashMap;
import java.util.Set;

public class Fact {


    private HashMap evales = new HashMap<String, Boolean>();

    protected String id;
    private String description;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Set<String> getIdSet() {
        return evales.keySet();
    }

    public void setFactValueById(String id, boolean value) {
        evales.put(id, value);

    }

    public boolean getValueById(String id) {

        return (Boolean) evales.get(id);
    }

    public String getDescription() {
        return description;
    }
}
