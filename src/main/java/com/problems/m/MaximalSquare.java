package com.problems.m;

/**
 * @author xhldtc on 2019-01-24.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] > 0) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        }));
    }
}
