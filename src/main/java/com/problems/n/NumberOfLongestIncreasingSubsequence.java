package com.problems.n;


public class NumberOfLongestIncreasingSubsequence {

    //dp[i]代表以第i个数为结尾的最长递增子串的长度和个数
    public int findNumberOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = new int[]{1, 1};
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int maxLen = dp[j][0] + 1;
                    if (maxLen > dp[i][0]) {
                        dp[i][0] = maxLen;
                        dp[i][1] = dp[j][1];
                    } else if (maxLen == dp[i][0]) {
                        dp[i][1] += dp[j][1];
                    }
                    max = Math.max(maxLen, max);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] == max) {
                res += dp[i][1];
            }
        }
        return res;
    }
}
