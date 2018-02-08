package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactRepositoryTest {

    private FactRepository testFactRepository;

    @BeforeEach
    void setUp() {
        testFactRepository = new FactRepository();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addFact() {
        testFactRepository.addFact(new Fact("id", "description"));
        assertEquals(1, testFactRepository.getFactList().size());
    }

    @Test
    void getFactList() {
        List<Fact> testFactRep = new ArrayList<>();
        assertEquals(testFactRepository.getFactList(), testFactRep);
    }

    @Test
    void getIterator() {
        addFact();
        assertTrue(testFactRepository.getIterator().hasNext());
        assertEquals("description", testFactRepository.getIterator().next().getDescription());
    }
}