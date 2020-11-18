package com.problems.p;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = prev * nums[i];
            prev = left[i];
        }
        prev = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = prev * nums[i];
            prev = right[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int l = i == 0 ? 1 : left[i - 1];
            int r = i == nums.length - 1 ? 1 : right[i + 1];
            res[i] = l * r;
        }
        return res;
    }
}
