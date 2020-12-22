package com.problems.t;

import java.util.*;

public class TimeBasedKeyValueStore {

    Map<String, List<Node>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeBasedKeyValueStore() {

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Node> list = map.get(key);
        if (timestamp < list.get(0).timestamp) {
            return "";
        }
        int index = Collections.binarySearch(list, new Node("", timestamp));
        if (index >= 0) {
            return list.get(index).value;
        } else {
            return list.get(-index - 2).value;
        }
    }

    static class Node implements Comparable<Node> {
        String value;
        int timestamp;

        Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        public int compareTo(Node e) {
            return Integer.compare(this.timestamp, e.timestamp);
        }

    }
}
