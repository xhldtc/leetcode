package com.problems.h;

/**
 * @author xhldtc on 23/11/2018.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int prevMaxInclude = nums[1];
            int prevMaxNotInclude = nums[0];
            for (int i = 2; i < nums.length; i++) {
                int temp = prevMaxNotInclude;
                prevMaxNotInclude = Math.max(prevMaxInclude, temp);
                prevMaxInclude = nums[i] + temp;
            }
            return Math.max(prevMaxInclude, prevMaxNotInclude);
        }
    }
}
