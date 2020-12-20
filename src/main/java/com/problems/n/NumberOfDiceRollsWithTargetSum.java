package com.problems.n;

public class NumberOfDiceRollsWithTargetSum {

    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d + 1][target + 1];
        long mod = 1000000007L;
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= f; j++) {
                for (int t = j; t <= Math.min(i * f, target); t++) {
                    dp[i][t] = (dp[i][t] + dp[i - 1][t - j]) % mod;
                }
            }
        }
        return (int) dp[d][target];
    }
}
