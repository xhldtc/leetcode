package com.problems.s;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    boolean search(int[] nums, int t, int start, int end) {
        if (start == end) {
            return false;
        } else if (start + 1 == end) {
            return nums[start] == t;
        } else if (start + 2 == end) {
            return nums[start] == t || nums[start + 1] == t;
        }

        if (nums[start] < nums[end - 1]) {
            return Arrays.binarySearch(nums, start, end, t) >= 0;
        } else {
            int mid = start + (end - start) / 2;
            return search(nums, t, start, mid) || search(nums, t, mid, end);
        }
    }
}
