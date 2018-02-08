package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionIteratorTest {
    int it;
    List list;
    QuestionIterator questionIterator;
    Question b;
    Question a;


    @BeforeEach
    void setUp() {
        it = 1;
        Answer no = new Answer();
        Answer yes = new Answer();
        a = new Question("a","b",no);
        b = new Question("b","b",yes);
        List<Question> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        questionIterator = new QuestionIterator(list);
    }

    @Test
    void hasNext() {
        assertEquals(true, questionIterator.hasNext(), "must be false");
        questionIterator.next();
        assertEquals(true, questionIterator.hasNext(), "must be false");
        questionIterator.next();
        assertEquals(false, questionIterator.hasNext(), "must be false");
    }

    @Test
    void next() {

        assertEquals(b.getQuestion(), questionIterator.next().getQuestion(), "must be b");
    }
}