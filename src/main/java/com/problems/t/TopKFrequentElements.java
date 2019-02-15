package com.problems.t;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xhldtc on 2019-02-15.
 */
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, (o, n) -> o + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.size(), Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> list = new ArrayList<>(k);
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements().topKFrequent(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2));
    }
}
