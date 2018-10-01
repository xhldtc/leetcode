package com.xhldtc;

import junit.framework.TestCase;

import java.util.Arrays;

public class TwoSumTest extends TestCase {

    private TwoSum twoSum = new TwoSum();

    public void testTwoSum() {
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertTrue(Arrays.equals(new int[]{0, 1}, result));
    }
}