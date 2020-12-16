package com.problems.l;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        boolean[][] b = new boolean[N][N];
        for (int[] m : mines) {
            b[m[0]][m[1]] = true;
        }
        int[][] dp = new int[N][N];
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!b[i][j]) {
                    dp[i][j] = 1;
                    res = 1;
                }
            }
        }
        int maxK = (N % 2 == 0) ? (N / 2) : ((N + 1) / 2);
        for (int k = 2; k <= maxK; k++) {
            for (int i = k - 1; i + k <= N; i++) {
                for (int j = k - 1; j + k <= N; j++) {
                    if (dp[i][j] == k - 1) {
                        int c = k - 1;
                        if (!b[i - c][j] && !b[i + c][j] && !b[i][j - c] && !b[i][j + c]) {
                            dp[i][j] = k;
                            res = k;
                        }
                    }
                }
            }
        }
        return res;
    }
}
