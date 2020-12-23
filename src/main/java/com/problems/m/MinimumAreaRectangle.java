package com.problems.m;

import java.util.*;

public class MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> xmap = new TreeMap<>();
        Map<Integer, Set<Integer>> ymap = new HashMap<>();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            if (!xmap.containsKey(x)) {
                xmap.put(x, new ArrayList<>());
            }
            xmap.get(x).add(y);
            if (!ymap.containsKey(y)) {
                ymap.put(y, new HashSet<>());
            }
            ymap.get(y).add(x);
        }
        int res = Integer.MAX_VALUE;
        for (int x : xmap.keySet()) {
            List<Integer> ys = xmap.get(x);
            for (int i = 0; i < ys.size(); i++) {
                for (int j = i + 1; j < ys.size(); j++) {
                    int y1 = ys.get(i);
                    int y2 = ys.get(j);
                    Set<Integer> set1 = ymap.get(y1);
                    Set<Integer> set2 = ymap.get(y2);
                    TreeSet<Integer> tmp = new TreeSet<>(set1);
                    tmp.retainAll(set2);
                    Integer xx = tmp.higher(x);
                    if (xx != null) {
                        res = Math.min(res, Math.abs(xx - x) * Math.abs(y1 - y2));
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
