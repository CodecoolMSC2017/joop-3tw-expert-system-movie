package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {


    private List<Question> rules = new ArrayList<>();


    public void addRule(Question question) {
        rules.add(question);
    }

    public List<Question> getRuleList() {
        return rules;
    }

    public Iterator<Question> getIterator() {

        return null;
    }
}
