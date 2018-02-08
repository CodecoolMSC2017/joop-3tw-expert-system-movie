package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {
    FactParser factParser;

    @BeforeEach
    void setUp() {
        factParser = new FactParser();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getFactRepository() {
        assertEquals("scifa", factParser.getFactRepository().getFactList().get(0).id);
        assertEquals("documentary", factParser.getFactRepository().getFactList().get(6).id);
    }

    @Test
    void loadXmlDocument() {
        assertThrows(FileNotFoundException.class, () ->factParser.loadXmlDocument("data.xml"));
    }

    @Test
    void getElements() {
    }
}