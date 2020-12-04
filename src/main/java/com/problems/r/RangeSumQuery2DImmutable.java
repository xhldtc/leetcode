package com.problems.r;

public class RangeSumQuery2DImmutable {

    int[][] matrix;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int left = j > 0 ? matrix[i][j - 1] : 0;
                int top = i > 0 ? matrix[i - 1][j] : 0;
                int leftTop = i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0;
                matrix[i][j] += left + top - leftTop;
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int left = col1 > 0 ? matrix[row2][col1 - 1] : 0;
        int top = row1 > 0 ? matrix[row1 - 1][col2] : 0;
        int leftTop = col1 > 0 && row1 > 0 ? matrix[row1 - 1][col1 - 1] : 0;
        return matrix[row2][col2] - left - top + leftTop;
    }
}
