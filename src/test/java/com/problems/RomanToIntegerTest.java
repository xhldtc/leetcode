package com.problems;

import junit.framework.TestCase;

public class RomanToIntegerTest extends TestCase {

    private RomanToInteger romanToInteger = new RomanToInteger();

    public void testRomanToInt() {
        assertEquals(3, romanToInteger.romanToInt("III"));
        assertEquals(4, romanToInteger.romanToInt("IV"));
        assertEquals(9, romanToInteger.romanToInt("IX"));
        assertEquals(58, romanToInteger.romanToInt("LVIII"));
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"));
    }
}