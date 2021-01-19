package com.problems.m;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] flag = new boolean[n];
        for (List<Integer> e : edges) {
            flag[e.get(1)] = true;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
