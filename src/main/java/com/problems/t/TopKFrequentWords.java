package com.problems.t;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
                return Integer.compare(e1.getValue(), e2.getValue());
            } else {
                return e2.getKey().compareTo(e1.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            q.offer(entry);
            if (q.size() > k) {
                q.poll();
            }
        }
        LinkedList<String> res = new LinkedList<>();
        while (!q.isEmpty()) {
            res.addFirst(q.poll().getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentWords().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
