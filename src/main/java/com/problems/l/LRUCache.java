package com.problems.l;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author xhldtc on 2019-01-16.
 */
public class LRUCache {

    private Map<Integer, Integer> mainMap = new HashMap<>();
    private Map<Integer, Integer> ageMap = new HashMap<>();
    private TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    private int age = 0;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0 || !mainMap.containsKey(key)) {
            return -1;
        }
        age++;
        int prevAge = ageMap.put(key, age);
        treeMap.remove(prevAge);
        treeMap.put(age, key);
        return mainMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        age++;
        if (mainMap.containsKey(key)) {
            mainMap.put(key, value);
            int prevAge = ageMap.put(key, age);
            treeMap.remove(prevAge);
            treeMap.put(age, key);
        } else {
            if (mainMap.size() == capacity) {
                int oldestAge = treeMap.firstKey();
                int oldestKey = treeMap.firstEntry().getValue();
                treeMap.remove(oldestAge);
                mainMap.remove(oldestKey);
                ageMap.remove(oldestKey);
            }
            mainMap.put(key, value);
            ageMap.put(key, age);
            treeMap.put(age, key);
        }
    }
}
