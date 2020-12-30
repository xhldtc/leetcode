package com.problems.p;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        int res = 0, start = 0;
        if ((nums.length > 0 && nums[0] != 1) || nums.length == 0) {
            res++;
        } else {
            start = 1;
        }
        long max = 1;
        for (int i = start; i < nums.length && max < n; i++) {
            long num = nums[i];
            if (max + 1 >= num) {
                max += num;
            } else {
                max = 2 * max + 1;
                res++;
                i--;
            }
        }
        while (max < (long) n) {
            max = 2 * max + 1;
            res++;
        }
        return res;
    }
}
