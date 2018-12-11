package com.problems.r;

/**
 * @author xhldtc on 11/12/2018.
 */
public class RangeSumQueryImmutable {

    private int[] nums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return nums[j];
        } else {
            return nums[j] - nums[i - 1];
        }
    }
}

