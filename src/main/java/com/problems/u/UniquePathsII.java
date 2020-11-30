package com.problems.u;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (obstacleGrid[i][j] == 0) {
                    int right = j == 0 ? 0 : dp[i][j - 1];
                    int top = i == 0 ? 0 : dp[i - 1][j];
                    dp[i][j] = right + top;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
