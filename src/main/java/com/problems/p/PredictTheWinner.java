package com.problems.p;

public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[len][len];
        for (int L = 1; L <= len; L++) {
            for (int i = 0; i + L - 1 < len; i++) {
                int j = i + L - 1;
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    int left = nums[i] + sum[j + 1] - sum[i + 1] - dp[i + 1][j];
                    int right = nums[j] + sum[j] - sum[i] - dp[i][j - 1];
                    dp[i][j] = Math.max(left, right);
                }
            }
        }
        return 2 * dp[0][len - 1] >= sum[len];
    }
}
