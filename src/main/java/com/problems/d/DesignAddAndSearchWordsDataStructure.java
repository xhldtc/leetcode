package com.problems.d;

public class DesignAddAndSearchWordsDataStructure {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public DesignAddAndSearchWordsDataStructure() {
        root = new Node((char) 0);
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node(ch);
            }
            curr = curr.children[ch - 'a'];
        }
        curr.in = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    boolean search(String word, Node node) {
        if (node == null) {
            return false;
        } else if (word.isEmpty()) {
            return node.in;
        }

        char ch = word.charAt(0);
        String sub = word.substring(1);
        if (ch == '.') {
            for (Node n : node.children) {
                if (search(sub, n)) {
                    return true;
                }
            }
            return false;
        } else {
            return search(sub, node.children[ch - 'a']);
        }
    }

    static class Node {

        char ch;
        Node[] children = new Node[26];
        boolean in;

        Node(char ch) {
            this.ch = ch;
        }
    }
}
