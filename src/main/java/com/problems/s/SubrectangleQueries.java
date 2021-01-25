package com.problems.s;

import java.util.ArrayList;
import java.util.List;

public class SubrectangleQueries {

    int[][] a;
    List<int[]> list = new ArrayList<>();

    public SubrectangleQueries(int[][] a) {
        this.a = a;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        list.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        int n = list.size();
        for(int i = n-1;i>=0;i--) {
            int[] b = list.get(i);
            if(row>= b[0] && row<=b[2] && col >= b[1] && col <=b[3]) {
                return b[4];
            }
        }
        return a[row][col];
    }
}
