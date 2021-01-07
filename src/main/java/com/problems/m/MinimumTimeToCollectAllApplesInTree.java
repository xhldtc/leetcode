package com.problems.m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumTimeToCollectAllApplesInTree {

    boolean[] flag;
    List<Boolean> app;
    Map<Integer, List<Integer>> map;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        app = hasApple;
        flag = new boolean[n];
        map = new HashMap<>();
        for(int[] e:edges) {
            map.computeIfAbsent(e[0], k-> new ArrayList<>()).add(e[1]);
            map.computeIfAbsent(e[1], k-> new ArrayList<>()).add(e[0]);
        }
        int res= dfs(0);
        return res == -1 ? 0 : res;
    }

    int dfs(int p) {
        flag[p] = true;
        List<Integer> list = map.get(p);
        int res = 0;
        for(Integer child: list) {
            if(!flag[child]) {
                int c = dfs(child);
                if(c>=0) {
                    res += c+2;
                }
            }
        }
        return !app.get(p) && res == 0 ? -1 :res;
    }
}
