package com.problems.l;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[t1.length() + 1][t2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            char ch1 = t1.charAt(i - 1);
            for (int j = 1; j < dp[i].length; j++) {
                char ch2 = t2.charAt(j - 1);
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (ch1 == ch2) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
        return dp[t1.length()][t2.length()];
    }
}
