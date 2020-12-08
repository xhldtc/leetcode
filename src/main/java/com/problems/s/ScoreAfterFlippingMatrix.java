package com.problems.s;

public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
            res += 1 << (A[0].length - 1);
        }
        for (int j = 1; j < A[0].length; j++) {
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                count += A[i][j];
            }
            res += (1 << (A[0].length - j - 1)) * Math.max(count, A.length - count);
        }
        return res;
    }
}
