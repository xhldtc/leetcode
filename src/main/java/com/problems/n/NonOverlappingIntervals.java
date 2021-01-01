package com.problems.n;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] a) {
        if (a.length == 0) {
            return 0;
        }
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0]) {
                return Integer.compare(x[0], y[0]);
            } else {
                return Integer.compare(x[1], y[1]);
            }
        });
        int max = a[0][1];
        int count = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i][1] < max) {
                max = a[i][1];
            } else if (a[i][0] >= max) {
                max = a[i][1];
                count++;
            }
        }
        return a.length - count;
    }
}
