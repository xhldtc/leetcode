package com.problems.s;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int max = n * n, curr = 1, i = 0, j = 0;
        while (curr <= max) {
            for (; j < n && res[i][j] == 0; j++) {
                res[i][j] = curr++;
            }
            j--;
            i++;
            for (; i < n && res[i][j] == 0; i++) {
                res[i][j] = curr++;
            }
            i--;
            j--;
            for (; j >= 0 && res[i][j] == 0; j--) {
                res[i][j] = curr++;
            }
            j++;
            i--;
            for (; i >= 0 && res[i][j] == 0; i--) {
                res[i][j] = curr++;
            }
            i++;
            j++;
        }
        return res;
    }
}
