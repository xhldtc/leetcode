package com.problems.p;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] a) {
        int row = a.length, col = a[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int curr = i * col + j;
                int top = (i - 1) * col + j;
                int left = i * col + j - 1;
                if (i > 0 && j > 0) {
                    q.offer(new int[]{curr, top, Math.abs(a[i][j] - a[i - 1][j])});
                    q.offer(new int[]{curr, left, Math.abs(a[i][j] - a[i][j - 1])});
                } else if (i > 0) {
                    q.offer(new int[]{curr, top, Math.abs(a[i][j] - a[i - 1][j])});
                } else if (j > 0) {
                    q.offer(new int[]{curr, left, Math.abs(a[i][j] - a[i][j - 1])});
                }
            }
        }

        int[] fa = new int[row * col];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }

        int res = 0;
        while (!connect(fa, row, col)) {
            int[] b = q.poll();
            union(b[0], b[1], fa);
            res = b[2];
        }
        return res;
    }

    boolean connect(int[] fa, int row, int col) {
        int x = find(0, fa);
        int y = find((row - 1) * col + col - 1, fa);
        return x == y;
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
