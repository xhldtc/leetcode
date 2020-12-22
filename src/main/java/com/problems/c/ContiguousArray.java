package com.problems.c;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int count0 = 0, count1 = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else {
                count1++;
            }
            int diff = count1 - count0;
            if (map.containsKey(diff)) {
                max = Math.max(max, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return max;
    }
}
