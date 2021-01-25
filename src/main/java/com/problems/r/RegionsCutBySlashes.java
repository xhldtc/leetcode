package com.problems.r;

import java.util.HashSet;
import java.util.Set;

public class RegionsCutBySlashes {

    public int regionsBySlashes(String[] grid) {
        int[] fa = new int[grid.length * grid.length * 4];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                int k = i * grid.length + j;
                int l = k * 4, t = k * 4 + 1, r = k * 4 + 2, b = k * 4 + 3;
                if (ch == '/') {
                    union(l, t, fa);
                    union(r, b, fa);
                } else if (ch == ' ') {
                    union(l, t, fa);
                    union(t, r, fa);
                    union(r, b, fa);
                } else {
                    union(l, b, fa);
                    union(t, r, fa);
                }
                if (i > 0) {
                    int top = (i - 1) * grid.length + j;
                    int topBottom = top * 4 + 3;
                    union(topBottom, t, fa);
                }
                if (j > 0) {
                    int left = i * grid.length + j - 1;
                    int leftRight = left * 4 + 2;
                    union(leftRight, l, fa);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fa.length; i++) {
            set.add(find(i, fa));
        }
        return set.size();
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
