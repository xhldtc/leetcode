package com.problems.s;

import java.util.*;

public class SmallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] fa = new int[s.length()];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (List<Integer> p : pairs) {
            union(p.get(0), p.get(1), fa);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < fa.length; i++) {
            int f = find(i, fa);
            map.computeIfAbsent(f, k -> new ArrayList<>()).add(i);
        }
        char[] res = new char[s.length()];
        for (List<Integer> list : map.values()) {
            char[] chs = new char[list.size()];
            int j = 0;
            for (Integer index : list) {
                chs[j++] = s.charAt(index);
            }
            Arrays.sort(chs);
            for (int i = 0; i < list.size(); i++) {
                res[list.get(i)] = chs[i];
            }
        }
        return new String(res);
    }

    int find(int x, int[] fa) {
        if (x == fa[x]) {
            return x;
        }
        fa[x] = find(fa[x], fa);
        return fa[x];
    }

    void union(int x, int y, int[] fa) {
        x = find(x, fa);
        y = find(y, fa);
        if (x == y) {
            return;
        }
        fa[x] = y;
    }
}
