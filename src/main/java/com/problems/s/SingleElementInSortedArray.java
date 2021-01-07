package com.problems.s;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        return solve(nums, 0, nums.length);
    }

    int solve(int[] nums, int start, int end) {
        if (start + 1 == end) {
            return nums[start];
        }
        int mid = start + (end - start) / 2;
        if (nums[mid - 1] == nums[mid]) {
            boolean even = (mid - start) % 2 == 0;
            return even ? solve(nums, start, mid - 1) : solve(nums, mid + 1, end);
        } else {
            boolean odd = (mid - start) % 2 == 1;
            return odd ? solve(nums, start, mid) : solve(nums, mid, end);
        }
    }
}
