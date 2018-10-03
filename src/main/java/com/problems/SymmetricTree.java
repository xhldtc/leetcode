package com.problems;

import com.structure.TreeNode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return check(root.left, root.right);
        }
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return false;
        } else if (right == null) {
            return false;
        } else {
            return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
        }
    }
}
