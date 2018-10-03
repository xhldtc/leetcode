package com.problems;

import com.structure.TreeNode;

public class MinimumDepthOfBinaryTree {

    private int result = Integer.MAX_VALUE;

    private void traversal(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (depth < result) {
                result = depth;
            }
        } else if (node.left == null) {
            traversal(node.right, depth + 1);
        } else if (node.right == null) {
            traversal(node.left, depth + 1);
        } else {
            traversal(node.left, depth + 1);
            traversal(node.right, depth + 1);
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root, 1);
        return result;
    }
}
