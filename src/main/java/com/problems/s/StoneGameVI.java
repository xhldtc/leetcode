package com.problems.s;

import java.util.Arrays;

public class StoneGameVI {

    public int stoneGameVI(int[] a, int[] b) {
        int[][] nodes = new int[a.length][2];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i][0] = i;
            nodes[i][1] = a[i] + b[i];
        }
        Arrays.sort(nodes, (x, y) -> Integer.compare(y[1], x[1]));
        int scoreA = 0, scoreB = 0;
        for (int i = 0; i < nodes.length; i++) {
            if (i % 2 == 0) {
                scoreA += a[nodes[i][0]];
            } else {
                scoreB += b[nodes[i][0]];
            }
        }
        return Integer.compare(scoreA, scoreB);
    }
}
