package com.codecool;

import java.util.HashMap;
import java.util.Set;

public class Fact {

    Set<String> setString;
    private HashMap evals = new HashMap<String, Boolean>();

    protected String id, description;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Set<String> getIdSet() {
        return setString;
    }

    public void setFactValueById(String id, boolean value) {
        evals.put(id, value);

    }

    public boolean getValueById(String id) {
        return true;
    }

    public String getDescription() {
        return description;
    }
}
