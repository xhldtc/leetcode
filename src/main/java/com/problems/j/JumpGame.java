package com.problems.j;

/**
 * @author xhldtc on 2019-02-25.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] mark = new boolean[nums.length];
        mark[0] = true;
        for (int j = 0; j <= nums[0] && j < nums.length; j++) {
            mark[j] = true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!mark[i]) {
                return false;
            }
            for (int j = i; j <= i + nums[i] && j < nums.length; j++) {
                mark[j] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{3,2,1,0,4}));
    }
}
