package com.problems.m;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> t) {
        int[] a = new int[t.size()];
        for (int i = 0; i < t.size(); i++) {
            String[] p = t.get(i).split(":");
            int h = Integer.parseInt(p[0]);
            int m = Integer.parseInt(p[1]);
            a[i] = h * 60 + m;
        }
        Arrays.sort(a);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                res = Math.min(res, a[0] + 24 * 60 - a[a.length - 1]);
            } else {
                res = Math.min(res, a[i] - a[i - 1]);
            }
        }
        return res;
    }
}
