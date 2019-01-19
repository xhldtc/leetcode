package com.problems.a;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xhldtc on 2019-01-16.
 */
class AllOne {

    /**
     * Initialize your data structure here.
     */
    private Map<String, Integer> map;
    private TreeMap<Integer, Set<String>> treeMap;

    public AllOne() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.put(key, value + 1);
            Set<String> set = treeMap.get(value);
            set.remove(key);
            if (set.isEmpty()) {
                treeMap.remove(value);
            }
            if (!treeMap.containsKey(value + 1)) {
                treeMap.put(value + 1, new HashSet<>());
            }
            treeMap.get(value + 1).add(key);
        } else {
            map.put(key, 1);
            if (!treeMap.containsKey(1)) {
                treeMap.put(1, new HashSet<>());
            }
            treeMap.get(1).add(key);
        }
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        int value = map.get(key);
        if (value == 1) {
            map.remove(key);
            Set<String> set = treeMap.get(1);
            set.remove(key);
            if (set.isEmpty()) {
                treeMap.remove(1);
            }
        } else {
            map.put(key, value - 1);
            Set<String> set = treeMap.get(value);
            set.remove(key);
            if (set.isEmpty()) {
                treeMap.remove(value);
            }
            if (!treeMap.containsKey(value - 1)) {
                treeMap.put(value - 1, new HashSet<>());
            }
            treeMap.get(value - 1).add(key);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (treeMap.isEmpty()) {
            return "";
        }
        return treeMap.get(treeMap.lastKey()).iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (treeMap.isEmpty()) {
            return "";
        }
        return treeMap.get(treeMap.firstKey()).iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
