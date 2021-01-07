package com.problems.r;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    public int minReorder(int n, int[][] conn) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] c : conn) {
            map.computeIfAbsent(c[0], k -> new ArrayList<>()).add(c);
            map.computeIfAbsent(c[1], k -> new ArrayList<>()).add(c);
        }
        boolean[] flag = new boolean[n];
        Deque<Integer> q = new LinkedList<>();
        q.offer(0);
        int res = 0;
        while (!q.isEmpty()) {
            int p = q.poll();
            flag[p] = true;
            List<int[]> edges = map.get(p);
            for (int[] e : edges) {
                if (!flag[e[0] + e[1] - p]) {
                    q.offer(e[0] + e[1] - p);
                    if (e[1] == p) {
                        res++;
                    }
                }
            }
        }
        return conn.length - res;
    }
}
