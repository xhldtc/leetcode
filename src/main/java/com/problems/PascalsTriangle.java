package com.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        List<Integer> one = Collections.singletonList(1);
        List<List<Integer>> result = new ArrayList<>();
        result.add(one);
        if (numRows == 1) {
            return result;
        } else {
            for (int row = 2; row <= numRows; row++) {
                int[] array = new int[row];
                array[0] = 1;
                array[row - 1] = 1;
                for (int i = 1; i < row - 1; i++) {
                    List<Integer> prevRow = result.get(row - 2);
                    array[i] = prevRow.get(i) + prevRow.get(i - 1);
                }
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < array.length; i++) {
                    list.add(array[i]);
                }
                result.add(list);
            }
            return result;
        }
    }
}
