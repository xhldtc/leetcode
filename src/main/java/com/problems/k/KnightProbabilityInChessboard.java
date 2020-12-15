package com.problems.k;

public class KnightProbabilityInChessboard {

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[2][N][N];
        dp[0][r][c] = 1d;
        int[][] dir = new int[][]{
                {2, 1},
                {2, -1},
                {1, 2},
                {1, -2},
                {-2, 1},
                {-2, -1},
                {-1, 2},
                {-1, -2}
        };
        int curr = 0, next;
        for (int k = 0; k < K; k++) {
            next = 1 - curr;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dp[next][i][j] = 0;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dp[curr][i][j] == 0) {
                        continue;
                    }
                    for (int d = 0; d < dir.length; d++) {
                        int row = i + dir[d][0];
                        int col = j + dir[d][1];
                        if (row >= 0 && row < N && col >= 0 && col < N) {
                            dp[next][row][col] += dp[curr][i][j] / 8d;
                        }
                    }
                }
            }
            curr = next;
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[curr][i][j];
            }
        }
        return res;
    }
}
