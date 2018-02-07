package com.codecool;

import java.util.Iterator;
import java.util.List;

public class QuestionIterator implements Iterator {

    private int it;
    private List<Question> list;

    public QuestionIterator(List<Question> list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (it < list.size()) {
            return true;
        }
        return false;
    }

    public Question next() {
        Question question = list.get(it);
        it++;
        return question;
    }

    public void remove() {
    }
}