package com.problems.m;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] p) {
        Arrays.sort(p, (p1, p2) -> {
            if (p1[0] != p2[0]) {
                return Integer.compare(p1[0], p2[0]);
            } else {
                return Integer.compare(p1[1], p2[1]);
            }
        });
        int[] dp = new int[p.length];
        int res = 1;
        for (int i = 0; i < p.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (p[j][1] < p[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
