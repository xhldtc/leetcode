package com.problems.i;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] f, int[][] s) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < f.length && j < s.length) {
            int[] a = f[i];
            int[] b = s[j];
            if (a[1] < b[0]) {
                i++;
            } else if (b[1] < a[0]) {
                j++;
            } else {
                res.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] < b[1]) {
                    i++;
                } else if (a[1] > b[1]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        int[][] r = new int[res.size()][2];
        for (i = 0; i < r.length; i++) {
            r[i] = res.get(i);
        }
        return r;
    }
}
