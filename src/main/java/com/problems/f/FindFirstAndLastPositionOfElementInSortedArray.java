package com.problems.f;

import java.util.Arrays;

/**
 * @author xhldtc on 2019-02-10.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        } else if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int index = Arrays.binarySearch(nums, 0, nums.length, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int l = left(nums, target, 0, index);
        int r = right(nums, target, index, nums.length - 1);
        return new int[]{l, r};
    }

    private int left(int[] nums, int target, int start, int end) {
        if (start == end) {
            return start;
        } else if (start + 1 == end) {
            return nums[start] == target ? start : end;
        } else {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return left(nums, target, start, mid);
            } else {
                return left(nums, target, mid, end);
            }
        }
    }

    private int right(int[] nums, int target, int start, int end) {
        if (start == end) {
            return start;
        } else if (start + 1 == end) {
            return nums[end] == target ? end : start;
        } else {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return right(nums, target, mid, end);
            } else {
                return right(nums, target, start, mid);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
