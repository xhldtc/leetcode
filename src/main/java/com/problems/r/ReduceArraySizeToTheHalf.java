package com.problems.r;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReduceArraySizeToTheHalf {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.merge(a, 1, Integer::sum);
        }
        int[] c = new int[map.size()];
        int i = 0;
        for (Integer count : map.values()) {
            c[i++] = count;
        }
        Arrays.sort(c);
        int res = 0, total = 0;
        for (i = c.length - 1; i >= 0; i--) {
            total += c[i];
            res++;
            if (total >= arr.length / 2) {
                break;
            }
        }
        return res;
    }
}
