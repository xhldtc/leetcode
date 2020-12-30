package com.problems.m;

import com.util.OneZeroTrie;

public class MaximumXORofTwoNumbersInAnArray {

    public int findMaximumXOR(int[] nums) {
        OneZeroTrie trie = new OneZeroTrie(5);
        for (int num : nums) {
            trie.add(num);
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num ^ trie.searchXOR(num));
        }
        return max;
    }

    static class OneZeroTrie {

        private int len;
        private Node root;

        public OneZeroTrie(int len) {
            this.len = len;
            this.root = new Node();
        }

        public void add(int num) {
            Node curr = root;
            for (int i = len - 1; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (curr.children[bit] == null) {
                    curr.children[bit] = new Node();
                }
                curr = curr.children[bit];
            }
            curr.val = num;
        }

        public int searchXOR(int num) {
            Node curr = root;
            for (int i = len - 1; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (curr.children[1 - bit] != null) {
                    curr = curr.children[1 - bit];
                } else {
                    curr = curr.children[bit];
                }
            }
            return curr.val;
        }

        private static class Node {
            int val;
            Node[] children = new Node[2];
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumXORofTwoNumbersInAnArray().findMaximumXOR(new int[]{8,10,2}));
    }
}
