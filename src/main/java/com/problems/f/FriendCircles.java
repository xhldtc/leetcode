package com.problems.f;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int[] fa = new int[M.length];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    union(i, j, fa);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < fa.length; i++) {
            if (i == fa[i])
                res++;
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
