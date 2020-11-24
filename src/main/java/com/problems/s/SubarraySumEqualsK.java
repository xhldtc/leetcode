package com.problems.s;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            if (map.containsKey(sum))
                map.put(sum, map.get(sum) + 1);
            else
                map.put(sum, 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[]{1,1,1}, 2));
    }
}
