package com.problems.q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensThatCanAttackTheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] d = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
                {-1, -1},
                {-1, 1},
                {1, 1},
                {1, -1}
        };
        boolean[] flag = new boolean[64];
        for (int[] q : queens) {
            flag[q[0] * 8 + q[1]] = true;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int[] a : d) {
            int i = 1;
            while (true) {
                int x = king[0] + i * a[0];
                int y = king[1] + i * a[1];
                if (x < 0 || y < 0 || x > 7 || y > 7) {
                    break;
                } else if (flag[x * 8 + y]) {
                    res.add(Arrays.asList(x, y));
                    break;
                }
                i++;
            }
        }
        return res;
    }
}
