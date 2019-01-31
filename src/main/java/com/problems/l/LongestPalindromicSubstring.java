package com.problems.l;

/**
 * @author xhldtc on 2019-01-31.
 * DP,如果dp[i-1][j+1]是回文串，并且i和j对应的字符相等，那么dp[i][j]也是回文串
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (i - j == 1) {
                        dp[i][j] = true;
                    } else if (dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j] && i + 1 - j > max) {
                    max = i + 1 - j;
                    result = s.substring(j, i + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
    }
}
