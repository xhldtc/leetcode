package com.problems.b;

public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] p) {
        int[][] dp = new int[p.length][5];
        dp[0][1] = -p[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - p[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + p[i], dp[i - 1][2]);
            if (i == 2) {
                dp[i][3] = p[1] - p[0] - p[i];
            } else if (i > 2) {
                dp[i][3] = Math.max(dp[i - 1][2] - p[i], dp[i - 1][3]);
                dp[i][4] = Math.max(dp[i - 1][3] + p[i], dp[i - 1][4]);
            }
        }
        int k = p.length - 1;
        return Math.max(Math.max(dp[k][0], dp[k][2]), dp[k][4]);
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{7,6,4,3,1}));
    }
}
