package com.problems.g;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class GetWatchedVideosByYourFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] b = new boolean[friends.length];
        Deque<Integer> q = new LinkedList<>();
        q.offer(id);
        b[id] = true;
        int currLev = 0;
        while (!q.isEmpty() && currLev < level) {
            currLev++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int curr = q.poll();
                for (int f : friends[curr]) {
                    if (!b[f]) {
                        b[f] = true;
                        q.offer(f);
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int num : q) {
            List<String> list = watchedVideos.get(num);
            for (String s : list) {
                map.merge(s, 1, Integer::sum);
            }
        }
        List<Pair<String, Integer>> pairs = new ArrayList<>();
        for (String key : map.keySet()) {
            pairs.add(new Pair<>(key, map.get(key)));
        }
        pairs.sort((p1, p2) -> {
            if (p1.getValue() != p2.getValue()) {
                return Integer.compare(p1.getValue(), p2.getValue());
            } else {
                return p1.getKey().compareTo(p2.getKey());
            }
        });
        return pairs.stream().map(Pair::getKey).collect(Collectors.toList());
    }
}
