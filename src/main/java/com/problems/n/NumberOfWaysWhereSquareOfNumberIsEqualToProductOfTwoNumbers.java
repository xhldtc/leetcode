package com.problems.n;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers {

    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> productMap1 = new HashMap<>();
        Map<Long, Integer> squareMap1 = new HashMap<>();
        Map<Long, Integer> productMap2 = new HashMap<>();
        Map<Long, Integer> squareMap2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            long x = nums1[i];
            squareMap1.merge(x * x, 1, Integer::sum);
            for (int j = 0; j < i; j++) {
                long y = nums1[j];
                productMap1.merge(y * x, 1, Integer::sum);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            long x = nums2[i];
            squareMap2.merge(x * x, 1, Integer::sum);
            for (int j = 0; j < i; j++) {
                long y = nums2[j];
                productMap2.merge(y * x, 1, Integer::sum);
            }
        }

        int res = 0;
        for (Long num : squareMap1.keySet()) {
            if (productMap2.containsKey(num)) {
                res += squareMap1.get(num) * productMap2.get(num);
            }
        }
        for (Long num : squareMap2.keySet()) {
            if (productMap1.containsKey(num)) {
                res += squareMap2.get(num) * productMap1.get(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfWaysWhereSquareOfNumberIsEqualToProductOfTwoNumbers().numTriplets(new int[]{7, 4, 5, 2}, new int[]{8, 9}));
    }
}
