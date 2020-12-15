package com.problems.o;

public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] s = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (char ch : strs[i].toCharArray()) {
                s[i][ch - '0']++;
            }
        }
        int[][][] dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j >= s[i][0] && k >= s[i][1]) {
                        if (i > 0) {
                            dp[i][j][k] = Math.max(1 + dp[i - 1][j - s[i][0]][k - s[i][1]], dp[i - 1][j][k]);
                        } else {
                            dp[i][j][k] = 1;
                        }
                    } else {
                        if (i > 0) {
                            dp[i][j][k] = dp[i - 1][j][k];
                        } else {
                            dp[i][j][k] = 0;
                        }
                    }
                }
            }
        }
        return dp[strs.length - 1][m][n];
    }
}
