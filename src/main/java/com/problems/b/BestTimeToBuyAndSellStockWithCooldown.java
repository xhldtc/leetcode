package com.problems.b;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] p) {
        if (p.length == 0) {
            return 0;
        }
        int[][] dp = new int[p.length][2];
        dp[0][0] = 0;
        dp[0][1] = -p[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(p[i] + dp[i - 1][1], dp[i - 1][0]);
            if (i >= 2)
                dp[i][1] = Math.max(dp[i - 2][0] - p[i], dp[i - 1][1]);
            else
                dp[i][1] = Math.max(-p[i], dp[i - 1][1]);
        }
        return dp[p.length - 1][0];
    }
}
