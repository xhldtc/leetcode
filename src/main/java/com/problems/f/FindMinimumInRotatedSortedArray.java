package com.problems.f;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        return find(nums, 0, nums.length);
    }

    int find(int[] nums, int start, int end) {
        if (start + 1 == end) {
            return nums[start];
        } else if (start + 2 == end) {
            return Math.min(nums[start], nums[start + 1]);
        } else if (nums.length == end - start && nums[0] < nums[end - 1]) {
            return nums[0];
        } else {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid] && nums[mid + 1] < nums[end - 1]) {
                return nums[mid + 1];
            } else if (nums[start] > nums[mid]) {
                return find(nums, start, mid + 1);
            } else {
                return find(nums, mid + 1, end);
            }
        }
    }
}
