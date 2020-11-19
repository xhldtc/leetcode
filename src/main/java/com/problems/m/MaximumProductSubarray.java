package com.problems.m;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int[] p = new int[nums.length];
        int[] n = new int[nums.length];
        int max = nums[0];
        if (max > 0) {
            p[0] = max;
        } else if (max < 0) {
            n[0] = max;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(0, max);
            } else if (nums[i] > 0) {
                if (p[i - 1] > 0) {
                    p[i] = p[i - 1] * nums[i];
                }
                if (n[i - 1] < 0) {
                    n[i] = n[i - 1] * nums[i];
                }
                p[i] = Math.max(p[i], nums[i]);
                max = Math.max(max, p[i]);
            } else {
                if (p[i - 1] > 0) {
                    n[i] = p[i - 1] * nums[i];
                }
                if (n[i - 1] < 0) {
                    p[i] = n[i - 1] * nums[i];
                }
                n[i] = Math.min(n[i], nums[i]);
                max = Math.max(max, p[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{0, 2}));

    }
}
