package com.problems.s;

import java.util.Arrays;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        if (target < matrix[0][0])
            return false;
        int left = 0, right = matrix.length - 1, index;
        while (true) {
            if (left == right) {
                index = left;
                break;
            } else if (left + 1 == right) {
                if (target >= matrix[left][0] && target < matrix[right][0]) {
                    index = left;
                    break;
                } else {
                    index = right;
                    break;
                }
            } else {
                int mid = left + (right - left) / 2;
                if (target == matrix[mid][0])
                    return true;
                else if (target < matrix[mid][0])
                    right = mid;
                else
                    left = mid;
            }
        }
        return Arrays.binarySearch(matrix[index], target) >= 0;
    }
}
