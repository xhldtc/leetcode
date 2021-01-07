package com.problems.e;

import com.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int d = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            boolean odd = d % 2 == 0;
            int prev = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (odd && node.val % 2 == 0) {
                    return false;
                }
                if (!odd && node.val % 2 == 1) {
                    return false;
                }
                if (i > 0) {
                    if (odd && node.val <= prev) {
                        return false;
                    }
                    if (!odd && node.val >= prev) {
                        return false;
                    }
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                prev = node.val;
            }
            d++;
        }
        return true;
    }
}
