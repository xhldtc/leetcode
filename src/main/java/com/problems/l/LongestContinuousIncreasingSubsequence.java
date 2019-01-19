package com.problems.l;

/**
 * @author xhldtc on 2019-01-19.
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1, curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
            } else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        return Math.max(max, curr);
    }
}
