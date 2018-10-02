package com.xhldtc;

import junit.framework.TestCase;

public class LongestCommonPrefixTest extends TestCase {

    private LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

    public void testLongestCommonPrefix() {
        assertEquals("fl", longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("", longestCommonPrefix.longestCommonPrefix(new String[]{}));
    }
}