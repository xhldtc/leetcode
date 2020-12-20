package com.problems.c;

import java.util.Arrays;

public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res += dp[n - 1][i];
        }
        return res;
    }
}
