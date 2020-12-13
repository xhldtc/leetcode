package com.problems.n;

public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        int[] fa = new int[n];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int[] p : connections) {
            union(p[0], p[1], fa);
        }
        int cluster = 0;
        for (int i = 0; i < fa.length; i++) {
            if (fa[i] == i) {
                cluster++;
            }
        }
        int res = cluster - 1;
        return (connections.length < n - 1) ? -1 : res;
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
