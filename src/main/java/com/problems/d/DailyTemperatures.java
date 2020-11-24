package com.problems.d;

import java.util.*;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        List<Integer>[] t = new List[101];
        for (int i = 0; i < T.length; i++) {
            int temp = T[i];
            if (t[temp] == null)
                t[temp] = new ArrayList<>();
            t[temp].add(i);
        }
        for (List<Integer> list : t) {
            if (list != null)
                list.sort(Integer::compare);
        }
        for (int i = 0; i < T.length; i++) {
            int temp = T[i];
            int found = Integer.MAX_VALUE;
            for (int j = temp + 1; j < t.length; j++) {
                if (t[j] != null && t[j].get(t[j].size() - 1) > i) {
                    int first = -Collections.binarySearch(t[j], i) - 1;
                    found = Math.min(found, t[j].get(first));
                }
            }
            T[i] = found == Integer.MAX_VALUE ? 0 : found - i;
        }
        return T;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
