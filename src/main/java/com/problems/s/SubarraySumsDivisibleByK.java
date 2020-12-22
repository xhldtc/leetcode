package com.problems.s;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] A, int K) {
        int[] sum = new int[A.length];
        int s = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            s += A[i];
            sum[i] = s % K;
            res += map.getOrDefault(sum[i], 0);
            if (sum[i] > 0) {
                res += map.getOrDefault(sum[i] - K, 0);
            } else if (sum[i] < 0) {
                res += map.getOrDefault(sum[i] + K, 0);
            }
            map.merge(sum[i], 1, Integer::sum);
        }
        return res;
    }
}
