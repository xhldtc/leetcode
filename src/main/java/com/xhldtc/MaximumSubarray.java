package com.xhldtc;

public class MaximumSubarray {

    /**
     * 求最大连续子串和：设nums[i]为以i元素结尾的最大连续子串和，那么以i+1元素结尾的最大连续子串和就是，若nums[i]>0,
     * 为nums[i]+nums[i+1],否则为nums[i+1]本身，然后把nums[i+1]更新成以i+1元素结尾的最大连续子串和，给后面使用，在过程中不断更新
     * 最大连续子串和的值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
