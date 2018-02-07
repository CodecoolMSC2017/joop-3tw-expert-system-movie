package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Answer {

   protected List<Value> valueList = new ArrayList<>();

    public Boolean evaluateAnswerByInput(String input) {

        if (input.equals("yes")){
            return Boolean.TRUE;
        }
        else if (input.equals("no")){
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    public void addValue(Value value) {
        valueList.add(value);
    }
}
