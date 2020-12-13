package com.problems.w;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int prev = nums[0], res = 1;
        boolean start = false;
        boolean increase = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                continue;
            }
            if (!start) {
                start = true;
                increase = nums[i] > prev;
                res++;
            } else {
                if (nums[i] > prev && !increase) {
                    increase = true;
                    res++;
                }
                if (nums[i] < prev && increase) {
                    increase = false;
                    res++;
                }
            }
            prev = nums[i];
        }
        return res;
    }
}
