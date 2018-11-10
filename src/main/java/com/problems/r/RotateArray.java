package com.problems.r;

/**
 * @author xhldtc on 10/11/2018.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            help(nums);
        }
    }

    public void help(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }
}
