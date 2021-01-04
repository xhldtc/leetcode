package com.problems.m;

import com.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 1, d = 1, max = root.val;
        while (!q.isEmpty()) {
            int size = q.size(), sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            if (sum > max) {
                max = sum;
                res = d;
            }
            d++;
        }
        return res;
    }
}
