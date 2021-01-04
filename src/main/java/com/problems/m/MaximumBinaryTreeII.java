package com.problems.m;

import com.structure.TreeNode;

public class MaximumBinaryTreeII {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        dfs(root, val);
        return root;
    }

    void dfs(TreeNode node, int val) {
        if (node.right == null) {
            node.right = new TreeNode(val);
        } else if (node.right.val < val) {
            TreeNode tmp = new TreeNode(val);
            tmp.left = node.right;
            node.right = tmp;
        } else {
            dfs(node.right, val);
        }
    }
}
