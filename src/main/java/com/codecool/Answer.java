package com.codecool;

public class Answer {


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


    }
}
