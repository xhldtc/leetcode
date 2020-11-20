package com.problems.f;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> m1 = count(A, B);
        Map<Integer, Integer> m2 = count(C, D);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            int match = -entry.getKey();
            if (m2.containsKey(match))
                res += entry.getValue() * m2.get(match);
        }
        return res;
    }

    Map<Integer, Integer> count(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            for (int j : b) {
                int key = i + j;
                map.merge(key, 1, Integer::sum);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(new FourSumII().fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
