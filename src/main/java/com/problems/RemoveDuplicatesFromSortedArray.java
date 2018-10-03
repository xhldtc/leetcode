package com.problems;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int prev = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[index++] = nums[i];
            }
            prev = nums[i];
        }
        return index;
    }
}
