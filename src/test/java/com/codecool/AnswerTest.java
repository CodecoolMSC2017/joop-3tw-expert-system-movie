package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    Answer answer;

    @BeforeEach
    void setUp() {
        answer = new Answer();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void evaluateAnswerByInput() {
        assertTrue(answer.evaluateAnswerByInput("yes"));
        assertFalse(answer.evaluateAnswerByInput("Yes"));
        assertFalse(answer.evaluateAnswerByInput("no"));
        assertFalse(answer.evaluateAnswerByInput(""));
    }

    @Test
    void addValue() {
        answer.addValue(new SingleValue("test", true));
        assertEquals("test", ((SingleValue)(answer.valueList.get(0))).getParam());
        assertTrue(answer.valueList.get(0).getSelectionType());
        assertEquals(1, answer.valueList.size());
    }
}