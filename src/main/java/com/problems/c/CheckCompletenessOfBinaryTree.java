package com.problems.c;

import com.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class CheckCompletenessOfBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty() && flag) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (flag) {
                    if (node.left == null && node.right != null) {
                        return false;
                    } else if (node.right == null) {
                        flag = false;
                        if (node.left != null) {
                            q.offer(node.left);
                        }
                    } else {
                        q.offer(node.left);
                        q.offer(node.right);
                    }
                } else if (node.left != null || node.right != null) {
                    return false;
                }
            }
        }
        return q.stream().allMatch(node -> node.left == null && node.right == null);
    }
}
