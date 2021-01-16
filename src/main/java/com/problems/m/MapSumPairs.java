package com.problems.m;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

    Node root = new Node(0);
    Map<String, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public MapSumPairs() {

    }

    public void insert(String key, int val) {
        boolean contain = false;
        int diff = 0;
        if (map.containsKey(key)) {
            diff = val - map.get(key);
            contain = true;
        }
        map.put(key, val);

        Node node = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = c - 'a';
            if (!contain) {
                if (node.child[index] == null) {
                    node.child[index] = new Node(val);
                } else {
                    node.child[index].val += val;
                }
            } else {
                node.child[index].val += diff;
            }
            node = node.child[index];
        }
    }

    public int sum(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.child[index] == null) {
                return 0;
            }
            node = node.child[index];
        }
        return node.val;
    }

    static class Node {
        int val;
        Node[] child = new Node[26];

        Node(int val) {
            this.val = val;
        }
    }
}
