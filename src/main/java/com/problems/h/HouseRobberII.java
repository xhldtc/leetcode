package com.problems.h;

public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] currWithFirst = new int[nums.length];
        int[] currNoFirst = new int[nums.length];
        int[] NoCurrWithFirst = new int[nums.length];
        int[] NoCurrNoFirst = new int[nums.length];
        currWithFirst[0] = nums[0];
        currNoFirst[1] = nums[1];
        NoCurrWithFirst[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (i == nums.length - 1) {
                currNoFirst[i] = nums[i] + NoCurrNoFirst[i - 1];
                NoCurrWithFirst[i] = Math.max(currWithFirst[i - 1], NoCurrWithFirst[i - 1]);
                NoCurrNoFirst[i] = Math.max(currNoFirst[i - 1], NoCurrNoFirst[i - 1]);
            } else {
                currWithFirst[i] = nums[i] + NoCurrWithFirst[i - 1];
                currNoFirst[i] = nums[i] + NoCurrNoFirst[i - 1];
                NoCurrWithFirst[i] = Math.max(currWithFirst[i - 1], NoCurrWithFirst[i - 1]);
                NoCurrNoFirst[i] = Math.max(currNoFirst[i - 1], NoCurrNoFirst[i - 1]);
            }
        }
        int j = nums.length - 1;
        int res = Math.max(currNoFirst[j], NoCurrWithFirst[j]);
        return Math.max(res, NoCurrNoFirst[j]);
    }
}
