package com.problems.c;

import java.util.Arrays;
import java.util.Comparator;

public class CheckingExistenceOfEdgeLengthLimitedPaths {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int[][] q = new int[queries.length][4];
        for (int i = 0; i < q.length; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = queries[i][2];
            q[i][3] = i;
        }
        Arrays.sort(q, Comparator.comparingInt(q2 -> q2[2]));
        Arrays.sort(edgeList, Comparator.comparingInt(e -> e[2]));
        boolean[] res = new boolean[q.length];

        int[] fa = new int[n];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        int index = 0;
        for (int[] query : q) {
            while (index < edgeList.length && edgeList[index][2] < query[2]) {
                union(edgeList[index][0], edgeList[index][1], fa);
                index++;
            }
            if (find(query[0], fa) == find(query[1], fa)) {
                res[query[3]] = true;
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
