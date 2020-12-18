package com.problems.k;

import java.util.Arrays;

public class KnightDialer {

    public int knightDialer(int n) {
        long[][] dp = new long[2][10];
        Arrays.fill(dp[0], 1);
        int prev = 0, curr;
        long mod = 1000000007;
        for (int i = 1; i < n; i++) {
            curr = 1 - prev;
            dp[curr][0] = (dp[prev][4] + dp[prev][6]) % mod;
            dp[curr][1] = (dp[prev][6] + dp[prev][8]) % mod;
            dp[curr][2] = (dp[prev][7] + dp[prev][9]) % mod;
            dp[curr][3] = (dp[prev][4] + dp[prev][8]) % mod;
            dp[curr][4] = (dp[prev][3] + dp[prev][9] + dp[prev][0]) % mod;
            dp[curr][5] = 0;
            dp[curr][6] = (dp[prev][1] + dp[prev][7] + dp[prev][0]) % mod;
            dp[curr][7] = (dp[prev][2] + dp[prev][6]) % mod;
            dp[curr][8] = (dp[prev][1] + dp[prev][3]) % mod;
            dp[curr][9] = (dp[prev][2] + dp[prev][4]) % mod;
            prev = curr;
        }
        long res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[prev][i]) % mod;
        }
        return (int) res;
    }
}
