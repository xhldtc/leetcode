package com.problems.r;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                sum++;
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
            }
        }
        return nums.length - sum;
    }
}
