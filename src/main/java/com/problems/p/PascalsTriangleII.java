package com.problems.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }
        List<Integer> prev = Collections.singletonList(1);
        for (int i = 1; i <= rowIndex; i++) {
            int[] array = new int[i + 1];
            array[0] = 1;
            array[i] = 1;
            for (int j = 1; j < i; j++) {
                array[j] = prev.get(j - 1) + prev.get(j);
            }
            prev = new ArrayList<>();
            for (int ii : array) {
                prev.add(ii);
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(4));
    }
}
