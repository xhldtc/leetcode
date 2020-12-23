package com.problems.a;

import java.util.*;

public class AvoidFloodInTheCity {

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            int r = rains[i];
            if (r == 0) {
                set.add(i);
            } else {
                res[i] = -1;
                if (map.containsKey(r)) {
                    int prev = map.get(r);
                    Integer sun = set.higher(prev);
                    if (sun == null) {
                        return new int[]{};
                    } else {
                        res[sun] = r;
                        set.remove(sun);
                    }
                }
                map.put(r, i);
            }
        }
        for (int index : set) {
            res[index] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AvoidFloodInTheCity().avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
    }
}
