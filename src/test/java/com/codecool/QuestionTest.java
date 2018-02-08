package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    Question question;

    @BeforeEach
    void setUp() {
        question = new Question("test", "What's a test?", new Answer());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        assertEquals("test", question.getId());
    }

    @Test
    void getQuestion() {
        assertEquals("What's a test?", question.getQuestion());
    }

    @Test
    void getAnswer() {
        assertEquals(0, question.getAnswer().valueList.size());
    }

    @Test
    void getEvaluatedAnswer() {
        assertTrue(question.getEvaluatedAnswer("yes"));
        assertFalse(question.getEvaluatedAnswer("no"));
    }
}