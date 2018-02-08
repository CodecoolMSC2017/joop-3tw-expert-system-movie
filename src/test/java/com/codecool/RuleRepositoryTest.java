package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleRepositoryTest {

    private RuleRepository testRuleRepository;

    @BeforeEach
    void setUp() {
        testRuleRepository = new RuleRepository();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addRule() {
        Question question = new Question("testId", "testQuestion", new Answer());
        testRuleRepository.addRule(question);
        Question returnQuestion = testRuleRepository.getIterator().next();
        assertEquals(returnQuestion, question);
        assertEquals(returnQuestion.getId(), "testId");
        assertEquals(returnQuestion.getQuestion(), "testQuestion");
    }

    @Test
    void getRuleList() {
        List<Question> testRuleRep = new ArrayList<>();
        assertEquals(testRuleRepository.getRuleList(), testRuleRep);
    }

    @Test
    void getIterator() {
        assertFalse(testRuleRepository.getIterator().hasNext());
        Question question = new Question("testId", "testQuestion", new Answer());
        testRuleRepository.addRule(question);
        assertTrue(testRuleRepository.getIterator().hasNext());
        assertEquals(testRuleRepository.getIterator().next(), question);
    }
}