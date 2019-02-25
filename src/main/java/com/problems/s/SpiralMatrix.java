package com.problems.s;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-02-25.
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> list = new LinkedList<>();
        spiral(matrix, 0, 0, matrix.length, matrix[0].length, list);
        return list;
    }

    private void spiral(int[][] matrix, int startRow, int startCol, int endRow, int endCol, List<Integer> list) {
        if (startRow >= endRow || startCol >= endCol) {
            return;
        }
        for (int i = startCol; i < endCol; i++) {
            list.add(matrix[startRow][i]);
        }
        if (startRow + 1 >= endRow) {
            return;
        }
        for (int i = startRow + 1; i < endRow; i++) {
            list.add(matrix[i][endCol - 1]);
        }
        if (endCol - 2 < startCol) {
            return;
        }
        for (int i = endCol - 2; i >= startCol; i--) {
            list.add(matrix[endRow - 1][i]);
        }
        if (endRow - 2 <= startRow) {
            return;
        }
        for (int i = endRow - 2; i > startRow; i--) {
            list.add(matrix[i][startCol]);
        }
        spiral(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, list);
    }

    public static void main(String[] args) {
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
    }
}
