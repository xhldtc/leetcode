package com.problems.f;

import java.util.Arrays;
import java.util.Collections;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 0;
        else if (len == 2)
            return nums[0] > nums[1] ? 0 : 1;
        else if (nums[0] > nums[1])
            return 0;
        else if (nums[len - 1] > nums[len - 2])
            return len - 1;
        else {
            int mid = len / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid - 1])
                return findPeakElement(Arrays.copyOfRange(nums, 0, mid));
            else
                return mid + findPeakElement(Arrays.copyOfRange(nums, mid, len));
        }
    }
}
