package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {
    RuleParser ruleParser;

    @BeforeEach
    void setUp() {
        ruleParser = new RuleParser();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRuleRepository() {
        assertEquals("funny",ruleParser.getRuleRepository().getRuleList().get(0).getId());
        assertEquals("realistic",ruleParser.getRuleRepository().getRuleList().get(3).getId());
    }

    @Test
    void loadXmlDocument() {
        assertThrows(FileNotFoundException.class, () ->ruleParser.loadXmlDocument("data.xml"));
    }

    @Test
    void getElements() {
    }
}