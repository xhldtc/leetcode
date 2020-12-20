package com.problems.m;

import java.util.Arrays;

public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        int[][] dp = new int[2][A[0].length + 2];
        Arrays.fill(dp[0], 1000);
        Arrays.fill(dp[1], 1000);
        for (int i = 1; i <= A[0].length; i++) {
            dp[0][i] = A[0][i - 1];
        }
        int prev = 0, curr;
        for (int i = 1; i < A.length; i++) {
            curr = 1 - prev;
            for (int j = 1; j <= A[i].length; j++) {
                dp[curr][j] = Math.min(dp[prev][j - 1] + A[i][j - 1], dp[prev][j] + A[i][j - 1]);
                dp[curr][j] = Math.min(dp[curr][j], dp[prev][j + 1] + A[i][j - 1]);
            }
            prev = curr;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= A[0].length; i++) {
            res = Math.min(dp[prev][i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }
}
