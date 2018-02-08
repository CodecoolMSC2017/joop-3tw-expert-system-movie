package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactIteratorTest {
    FactIterator factiterator;
    Fact a;
    Fact b;

    @BeforeEach
    void setUp() {
        a = new Fact("a","1");
        b = new Fact("b","2");
        List<Fact> list = new ArrayList<>();
        factiterator = new FactIterator(list);
        list.add(a);
        list.add(b);
    }

    @Test
    void hasNext() {
        assertEquals(true, factiterator.hasNext(), "must be true");
        factiterator.next();
        assertEquals(true, factiterator.hasNext(), "must be true");
        factiterator.next();
        assertEquals(false, factiterator.hasNext(), "must be false");
    }

    @Test
    void next() {
        assertEquals(b.getIdSet(), factiterator.next().getIdSet(), "must be b");
    }
}