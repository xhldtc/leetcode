package com.problems.p;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(toInt(cells), 0);
        int index = 1;
        int remain;
        int[] base;
        while (true) {
            cells = convert(cells);
            if (index == N) {
                return cells;
            }
            int num = toInt(cells);
            if (map.containsKey(num)) {
                int prev = map.get(num);
                base = cells;
                int period = index - prev;
                remain = (N - prev) % period;
                break;
            }
            map.put(num, index);
            index++;
        }
        for (int i = 0; i < remain; i++) {
            base = convert(base);
        }
        return base;
    }

    int[] convert(int[] A) {
        int[] res = new int[A.length];
        for (int i = 1; i < res.length - 1; i++) {
            int left = A[i - 1];
            int right = A[i + 1];
            if ((left == 0 && right == 0) || (left == 1 && right == 1)) {
                res[i] = 1;
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    int toInt(int[] A) {
        int res = 0;
        for (int num : A) {
            res = (res << 1) + num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)));
    }
}
