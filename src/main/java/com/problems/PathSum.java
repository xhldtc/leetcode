package com.problems;

import com.structure.TreeNode;

public class PathSum {

    private boolean result = false;

    private void traversal(TreeNode node, int curr, int sum) {
        if (result) {
            return;
        }
        if (node.left == null && node.right == null) {
            result = curr + node.val == sum;
        } else if (node.left == null) {
            traversal(node.right, curr + node.val, sum);
        } else if (node.right == null) {
            traversal(node.left, curr + node.val, sum);
        } else {
            traversal(node.left, curr + node.val, sum);
            traversal(node.right, curr + node.val, sum);
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        traversal(root, 0, sum);
        return result;
    }
}
