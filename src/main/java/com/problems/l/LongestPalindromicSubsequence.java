package com.problems.l;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len][len];
        for (int L = 1; L <= len; L++) {
            for (int i = 0; i + L - 1 < len; i++) {
                int j = i + L - 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i + 1 == j) {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    if (chars[i] == chars[j]) {
                        dp[i][j] = Math.max(2 + dp[i + 1][j - 1], dp[i][j]);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
