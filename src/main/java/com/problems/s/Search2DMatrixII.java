package com.problems.s;

public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        return search(matrix, 0, 0, matrix.length, matrix[0].length, target);
    }

    private boolean search(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int target) {
        if (startRow == endRow || startCol == endCol)
            return false;
        if (startRow + 1 == endRow && startCol + 1 == endCol)
            return matrix[startRow][startCol] == target;
        int midRow = startRow + (endRow - startRow) / 2;
        int midCol = startCol + (endCol - startCol) / 2;
        if (matrix[midRow][midCol] == target)
            return true;
        else if (matrix[midRow][midCol] < target) {
            return search(matrix, midRow + 1, midCol + 1, endRow, endCol, target) ||
                    search(matrix, startRow, midCol + 1, midRow + 1, endCol, target) ||
                    search(matrix, midRow + 1, startCol, endRow, midCol + 1, target);
        } else {
            return search(matrix, startRow, startCol, midRow, midCol, target) ||
                    search(matrix, startRow, midCol, midRow, endCol, target) ||
                    search(matrix, midRow, startCol, endRow, midCol, target);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(new Search2DMatrixII().searchMatrix(matrix, 5));
    }
}
