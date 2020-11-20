package com.problems.w;

import java.util.Arrays;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] copy = nums.clone();
        int minIndex, maxIndex, index = 0;
        if (nums.length % 2 == 0) {
            minIndex = nums.length - 2;
            maxIndex = nums.length - 1;
        } else {
            minIndex = nums.length - 1;
            maxIndex = nums.length - 2;
        }
        for (int i = minIndex; i >= 0; i -= 2)
            nums[i] = copy[index++];
        for (int i = maxIndex; i >= 0; i -= 2)
            nums[i] = copy[index++];
    }

    public static void main(String[] args) {
        new WiggleSortII().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
        new WiggleSortII().wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
        new WiggleSortII().wiggleSort(new int[]{4, 5, 5, 6});
    }
}
