package com.problems.b;

import com.structure.TreeNode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (root.val == 0 && left == null && right == null) {
            return null;
        } else {
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
