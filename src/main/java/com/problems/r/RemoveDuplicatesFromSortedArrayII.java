package com.problems.r;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int prev = Integer.MAX_VALUE, slot = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev) {
                count = 1;
                if (slot != -1) {
                    nums[slot++] = nums[i];
                }
            } else {
                count++;
                if (count > 2 && slot == -1) {
                    slot = i;
                } else if (count < 3 && slot != -1) {
                    nums[slot++] = nums[i];
                }
            }
            prev = nums[i];
        }
        return slot == -1 ? nums.length : slot;
    }
}
