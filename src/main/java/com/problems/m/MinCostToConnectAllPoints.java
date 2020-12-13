package com.problems.m;

import java.util.Arrays;
import java.util.Comparator;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        int totalEdget = points.length * (points.length - 1) / 2;
        Edge[] edges = new Edge[totalEdget];
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < i; j++) {
                Edge e = new Edge(i, j);
                e.dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[index++] = e;
            }
        }
        Arrays.sort(edges, Comparator.comparingInt(e -> e.dis));

        int[] fa = new int[points.length];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        int res = 0, total = 0;
        for (int i = 0; i < edges.length && total < points.length - 1; i++) {
            int u = find(edges[i].u, fa);
            int v = find(edges[i].v, fa);
            if (u != v) {
                fa[u] = v;
                res += edges[i].dis;
                total++;
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

    static class Edge {
        int u, v;
        int dis;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}
