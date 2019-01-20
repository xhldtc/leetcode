package com.problems.s;

import java.util.Arrays;

/**
 * @author xhldtc on 2019-01-20.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length <= 3) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        int split = findIndex(nums, 0, nums.length);
        int result = Arrays.binarySearch(nums, 0, split, target);
        if (result >= 0) {
            return result;
        } else {
            result = Arrays.binarySearch(nums, split, nums.length, target);
            return result < 0 ? -1 : result;
        }
    }

    public int findIndex(int[] nums, int left, int right) {
        if (right - left == 2) {
            return left + 1;
        } else if (right - left == 3) {
            return nums[left] > nums[left + 1] ? left + 1 : left + 2;
        }
        int mid = left + (right - left) / 2;
        if (nums[left] < nums[mid - 1] && nums[mid] < nums[right - 1]) {
            return mid;
        } else if (nums[left] < nums[mid - 1]) {
            return findIndex(nums, mid, right);
        } else {
            return findIndex(nums, left, mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}
