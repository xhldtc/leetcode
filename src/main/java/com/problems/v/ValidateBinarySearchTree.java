package com.problems.v;

import com.structure.TreeNode;

/**
 * @author xhldtc on 2019-03-04.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            return root.right.val > root.val && isValidBST(root.right) && left(root.right) > root.val;
        } else if (root.right == null) {
            return root.left.val < root.val && isValidBST(root.left) && right(root.left) < root.val;
        } else {
            return root.right.val > root.val && root.left.val < root.val
                    && isValidBST(root.right) && isValidBST(root.left)
                    && left(root.right) > root.val && right(root.left) < root.val;
        }
    }

    private int left(TreeNode node) {
        int val = 0;
        while (node != null) {
            val = node.val;
            node = node.left;
        }
        return val;
    }

    private int right(TreeNode node) {
        int val = 0;
        while (node != null) {
            val = node.val;
            node = node.right;
        }
        return val;
    }
}
