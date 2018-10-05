package com.problems.c;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            map.put(1, 1);
            return 1;
        } else if (n == 2) {
            map.put(2, 2);
            return 2;
        } else {
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
            return result;
        }
    }
}
