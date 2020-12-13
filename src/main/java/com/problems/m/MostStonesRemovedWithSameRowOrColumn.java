package com.problems.m;

public class MostStonesRemovedWithSameRowOrColumn {

    public int removeStones(int[][] stones) {
        int[] fa = new int[stones.length];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j < i; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j, fa);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < fa.length; i++) {
            if (fa[i] != i) {
                res++;
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

    void union(int x, int y, int[] fa) {
        x = find(x, fa);
        y = find(y, fa);
        if (x == y) {
            return;
        }
        fa[x] = y;
    }
}
