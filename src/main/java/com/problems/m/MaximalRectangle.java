package com.problems.m;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int left = j > 0 ? 1 + matrix[i][j - 1] : '1';
                    matrix[i][j] = (char) left;
                    res = Math.max(res, left - '0');
                    int width = left - '0';
                    for (int k = i - 1; k >= 0; k--) {
                        if (matrix[k][j] == '0') {
                            break;
                        }
                        width = Math.min(width, matrix[k][j] - '0');
                        res = Math.max(res, width * (i - k + 1));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle().maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }
}
