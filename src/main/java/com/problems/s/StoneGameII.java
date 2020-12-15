package com.problems.s;

public class StoneGameII {

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + piles[i - 1];
        }

        int[][] dp = new int[len][len + 1];
        int nextM, sumPrevX, sumRemain, nextDp;
        for (int i = len - 1; i >= 0; i--) {
            for (int m = 1; m <= len; m++) {
                dp[i][m] = piles[i];
                for (int x = 1; x <= 2 * m && i + x <= len; x++) {
                    nextM = Math.min(Math.max(x, m), len);
                    sumPrevX = sum[i + x] - sum[i];
                    sumRemain = sum[len] - sum[i + x];
                    nextDp = (i + x < len) ? dp[i + x][nextM] : 0;
                    dp[i][m] = Math.max(dp[i][m], sumPrevX + sumRemain - nextDp);
                }
            }
        }
        return dp[0][1];
    }
}
