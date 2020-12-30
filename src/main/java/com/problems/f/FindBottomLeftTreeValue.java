package com.problems.f;

import com.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = root.val;
        while (!q.isEmpty()) {
            int size = q.size();
            res = q.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}
