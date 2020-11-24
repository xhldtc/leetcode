package com.problems.s;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == sorted[left])
                left++;
            else if (nums[right] == sorted[right])
                right--;
            else
                break;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1}));
    }
}
