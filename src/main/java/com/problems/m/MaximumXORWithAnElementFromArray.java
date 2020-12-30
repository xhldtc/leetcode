package com.problems.m;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class MaximumXORWithAnElementFromArray {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int[][] qs = new int[queries.length][3];
        int maxX = 0;
        for (int i = 0; i < queries.length; i++) {
            qs[i] = new int[]{queries[i][0], queries[i][1], i};
            maxX = Math.max(maxX, queries[i][0]);
        }
        Arrays.sort(qs, Comparator.comparingInt(q -> q[1]));
        int len = Math.max(Integer.toBinaryString(set.last()).length(), Integer.toBinaryString(maxX).length());
        Node root = null;
        int[] res = new int[queries.length];
        for (int i = 0; i < qs.length; i++) {
            int x = qs[i][0];
            int m = qs[i][1];
            int index = qs[i][2];
            while (!set.isEmpty() && set.first() <= m) {
                if (root == null) {
                    root = new Node();
                }
                addNode(root, set.first(), len);
                set.remove(set.first());
            }
            res[index] = search(root, x, len) ^ x;
        }
        return res;
    }

    void addNode(Node root, int num, int len) {
        String s = padPrefix(Integer.toBinaryString(num), len);
        Node curr = root;
        for (char ch : s.toCharArray()) {
            int index = ch - '0';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.val = num;
    }

    int search(Node root, int x, int len) {
        if (root == null) {
            return -1;
        }
        String s = padPrefix(Integer.toBinaryString(x), len);
        Node curr = root;
        for (char ch : s.toCharArray()) {
            int index = ch - '0';
            if (curr.children[1 - index] != null) {
                curr = curr.children[1 - index];
            } else {
                curr = curr.children[index];
            }
        }
        return curr.val;
    }

    String padPrefix(String s, int len) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < len) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    static class Node {
        int val = -1;
        Node[] children = new Node[2];
    }
}
