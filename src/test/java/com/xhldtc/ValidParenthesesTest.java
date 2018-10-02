package com.xhldtc;

import junit.framework.TestCase;

public class ValidParenthesesTest extends TestCase {

    private ValidParentheses validParentheses = new ValidParentheses();

    public void testIsValid() {
        assertEquals(true, validParentheses.isValid("()"));
        assertEquals(true, validParentheses.isValid("()[]{}"));
        assertEquals(false, validParentheses.isValid("(]"));
        assertEquals(false, validParentheses.isValid("([)]"));
        assertEquals(true, validParentheses.isValid("{[]}"));
    }
}