package com.problems.t;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            int sum = solve(nums, i + 1, target - a);
            if (Math.abs(sum + a - target) < Math.abs(ret - target)) {
                ret = sum + a;
            }
        }
        return ret;
    }

    int solve(int[] nums, int start, int target) {
        int left = start, right = nums.length - 1;
        int res = nums[left] + nums[right];
        while (left < right) {
            int curr = nums[left] + nums[right];
            int diff = Math.abs(curr - target);
            if (diff < Math.abs(res - target)) {
                res = curr;
            }
            if (curr < target) {
                left++;
            } else if (curr > target) {
                right--;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
