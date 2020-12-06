package com.problems.f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (x, y) -> Integer.compare(y[0] + y[1], x[0] + x[1]));
        for (int a : nums1) {
            for (int b : nums2) {
                if (queue.size() < k) {
                    queue.add(new int[]{a, b});
                } else {
                    int[] arr = queue.peek();
                    if (a + b < arr[0] + arr[1]) {
                        queue.poll();
                        queue.add(new int[]{a, b});
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int[] arr : queue) {
            res.add(Arrays.asList(arr[0], arr[1]));
        }
        return res;
    }
}
