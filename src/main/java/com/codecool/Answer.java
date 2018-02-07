package com.codecool;

import java.util.List;

public class Answer {

   List<Value> valueList;

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
