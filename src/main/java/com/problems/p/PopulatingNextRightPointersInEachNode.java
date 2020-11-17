package com.problems.p;

import com.structure.Node;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null)
            return null;
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        int levelCount = 1, count = 0;
        while (!list.isEmpty()) {
            Node curr = list.removeFirst();
            count++;
            if (count == levelCount) {
                levelCount <<= 1;
                count = 0;
            } else if (!list.isEmpty()) {
                curr.next = list.getFirst();
            }
            if (curr.left != null && curr.right != null) {
                list.add(curr.left);
                list.add(curr.right);
            }
        }
        return root;
    }
}
