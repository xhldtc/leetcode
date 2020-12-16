package com.problems.c;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        k = Math.abs(k);
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = k != 0 ? (sum[i - 1] + nums[i - 1]) % k : (sum[i - 1] + nums[i - 1]);
        }
        if (k == 0) {
            for (int i = 0; i < sum.length; i++) {
                if ((i + 2) < sum.length && sum[i] == sum[i + 2]) {
                    return true;
                }
            }
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            int val = sum[i];
            if (!map.containsKey(val)) {
                map.put(val, i);
            } else if (i > map.get(val) + 1) {
                return true;
            }
        }
        return false;
    }
}
