package com.problems.t;

import java.util.Arrays;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        if (S < -1000 || S > 1000)
            return 0;
        int[] curr = new int[2001], next = new int[2001], temp;
        int base = 1000;
        curr[base] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < curr.length; j++) {
                if (curr[j] > 0) {
                    next[j + nums[i]] += curr[j];
                    next[j - nums[i]] += curr[j];
                }
            }
            temp = curr;
            curr = next;
            next = temp;
            Arrays.fill(next, 0);
        }
        return curr[S + base];
    }

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
