package com.example.pvtest;

import org.junit.Rule;

import static org.junit.Assert.assertEquals;

public class JunitRuleTest {

    @Rule
    public final JUnitPVRule jUnitPVRule = new JUnitPVRule();

    @org.junit.Test
    public void test1() {
        assertEquals(1, 1);
    }


}
