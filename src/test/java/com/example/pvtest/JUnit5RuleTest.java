package com.example.pvtest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(JUnitPVRule.class)

public class JUnit5RuleTest {

    String name = "pippo";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void testOne() {
        assertEquals(1, computeOne());
    }

    private int computeOne() {
        return 0/0;
    }
}
