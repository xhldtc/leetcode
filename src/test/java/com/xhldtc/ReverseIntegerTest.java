package com.xhldtc;

import junit.framework.TestCase;

public class ReverseIntegerTest extends TestCase {

    private ReverseInteger reverseInteger = new ReverseInteger();

    public void testReverse() {
        assertEquals(321, reverseInteger.reverse(123));
        assertEquals(-321, reverseInteger.reverse(-123));
        assertEquals(21, reverseInteger.reverse(120));
        assertEquals(0, reverseInteger.reverse(Integer.MIN_VALUE));
        assertEquals(0, reverseInteger.reverse(Integer.MAX_VALUE));
    }
}