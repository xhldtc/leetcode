package com.problems.c;

public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][][] mark = new int[r][c][2];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int left = j > 0 ? mark[i][j - 1][0] : 0;
                if (matrix[i][j] == 1) {
                    mark[i][j][0] = 1 + left;
                }
                int up = i > 0 ? mark[i - 1][j][1] : 0;
                if (matrix[i][j] == 1) {
                    mark[i][j][1] = 1 + up;
                }
            }
        }
        int[][] dp = new int[r][c];
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1;
                    int min = Math.min(mark[i][j][0], mark[i][j][1]);
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j] = Math.min(1 + dp[i - 1][j - 1], min);
                    }
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
