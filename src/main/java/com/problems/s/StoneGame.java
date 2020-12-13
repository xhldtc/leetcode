package com.problems.s;

public class StoneGame {

    //dp[i][j]代表i,j区间先手可拿的最大石子数量
    public boolean stoneGame(int[] piles) {
        int[] sum = new int[piles.length];
        sum[0] = piles[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + piles[i];
        }
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int k = 2; k <= len; k++) {
            for (int i = 0; i + k - 1 < len; i++) {
                int j = i + k - 1;
                int left = i > 0 ? sum[i - 1] : 0;
                dp[i][j] = Math.max(piles[i] + sum[j] - sum[i] - dp[i + 1][j], piles[j] + sum[j - 1] - left - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] * 2 > sum[piles.length - 1];
    }
}
