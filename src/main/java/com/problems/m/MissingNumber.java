package com.problems.m;

/**
 * @author xhldtc on 25/11/2018.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
