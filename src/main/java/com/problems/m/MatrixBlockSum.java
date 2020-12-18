package com.problems.m;

public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = j > 0 ? mat[i][j - 1] : 0;
                int up = i > 0 ? mat[i - 1][j] : 0;
                int leftUp = (i > 0 && j > 0) ? mat[i - 1][j - 1] : 0;
                mat[i][j] += left + up - leftUp;
            }
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = i - K, r2 = i + K, c1 = j - K, c2 = j + K;
                r1 = Math.max(r1, 0);
                r2 = r2 < m ? r2 : m - 1;
                c1 = Math.max(c1, 0);
                c2 = c2 < n ? c2 : n - 1;
                dp[i][j] = query(mat, r1, c1, r2, c2);
            }
        }
        return dp;
    }

    int query(int[][] mat, int r1, int c1, int r2, int c2) {
        int left = (c1 > 0) ? mat[r2][c1 - 1] : 0;
        int up = (r1 > 0) ? mat[r1 - 1][c2] : 0;
        int leftUp = (r1 > 0 && c1 > 0) ? mat[r1 - 1][c1 - 1] : 0;
        return mat[r2][c2] - left - up + leftUp;
    }
}
