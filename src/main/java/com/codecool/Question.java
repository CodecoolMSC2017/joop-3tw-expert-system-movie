package com.codecool;

public class Question {

    public Question(String id, String question, Answer answer) {
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean getEvaluatedAnswer(String input) {
        return true;
    }
}
