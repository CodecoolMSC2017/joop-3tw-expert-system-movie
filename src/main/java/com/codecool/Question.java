package com.codecool;

public class Question {

    public Question(String id, String question, Answer answer) {
    }

    public String getId() {
        String id = "";
        return id;
    }

    public String getQuestion() {
        String question = "";
        return question;
    }

    public Answer getAnswer() {
        Answer answer = new Answer();
        return answer;
    }

    public boolean getEvaluatedAnswer(String input) {
        return true;
    }
}
