package com.problems.b;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] p) {
        if (p.length == 0) {
            return 0;
        }
        k = Math.min(k, p.length / 2);
        int[][][] dp = new int[p.length][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -p[0];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0)
                    dp[i][j][0] = Math.max(dp[i - 1][j - 1][1] + p[i], dp[i - 1][j][0]);
                else
                    dp[i][j][0] = dp[i - 1][j][0];
                dp[i][j][1] = Math.max(dp[i - 1][j][0] - p[i], dp[i - 1][j][1]);
            }
        }
        return dp[p.length - 1][k][0];
    }
}
