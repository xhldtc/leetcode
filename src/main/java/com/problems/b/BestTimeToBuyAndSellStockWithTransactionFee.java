package com.problems.b;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] p, int fee) {
        int[][] dp = new int[p.length][2];
        dp[0][0] = 0;
        dp[0][1] = -p[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(p[i] + dp[i - 1][1] - fee, dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - p[i], dp[i - 1][1]);
        }
        return dp[p.length - 1][0];
    }
}
