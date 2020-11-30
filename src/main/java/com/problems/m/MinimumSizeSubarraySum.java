package com.problems.m;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, left = 0, right = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum < s) {
                sum += nums[right++];
            } else {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        while (sum >= s) {
            min = Math.min(min, right - left);
            sum -= nums[left++];
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
