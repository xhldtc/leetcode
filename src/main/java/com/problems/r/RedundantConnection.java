package com.problems.r;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        int[] fa = new int[N];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        int[] res = null;
        for (int[] e : edges) {
            int x = find(e[0] - 1, fa);
            int y = find(e[1] - 1, fa);
            if (x == y) {
                res = e;
                break;
            } else {
                fa[x] = y;
            }
        }
        return res;
    }

    int find(int x, int[] fa) {
        if (x == fa[x]) {
            return x;
        }
        fa[x] = find(fa[x], fa);
        return fa[x];
    }
}
