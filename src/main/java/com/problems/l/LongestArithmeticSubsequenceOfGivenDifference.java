package com.problems.l;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequenceOfGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for (int a : arr) {
            int prev = a - difference;
            Integer prevMax = map.get(prev);
            if (prevMax != null) {
                map.put(a, prevMax + 1);
                res = Math.max(res, prevMax + 1);
            } else {
                map.put(a, 1);
            }
        }
        return res;
    }
}
