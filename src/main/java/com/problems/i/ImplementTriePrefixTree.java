package com.problems.i;

import java.util.ArrayList;
import java.util.List;

public class ImplementTriePrefixTree {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public ImplementTriePrefixTree() {
        root = new Node((char) 0);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            Node find = curr.child(ch);
            if (find != null)
                curr = find;
            else {
                Node child = new Node(ch);
                curr.children.add(child);
                curr = child;
            }
        }
        curr.in = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            Node find = curr.child(ch);
            if (find != null)
                curr = find;
            else
                return false;
        }
        return curr.in;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char ch : prefix.toCharArray()) {
            Node find = curr.child(ch);
            if (find != null)
                curr = find;
            else
                return false;
        }
        return true;
    }

    class Node {
        char ch;
        List<Node> children;
        boolean in;

        Node(char ch) {
            this.ch = ch;
            this.children = new ArrayList<>();
        }

        Node child(char ch) {
            for (Node n : children) {
                if (n.ch == ch)
                    return n;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree trie = new ImplementTriePrefixTree();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
