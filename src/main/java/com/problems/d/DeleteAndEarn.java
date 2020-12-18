package com.problems.d;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] src = new int[max + 1];
        for (int num : nums) {
            src[num]++;
        }
        int[] dp = new int[src.length];
        dp[0] = 0;
        dp[1] = src[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * src[i]);
        }
        return dp[dp.length - 1];
    }
}
