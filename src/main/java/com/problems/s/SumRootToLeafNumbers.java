package com.problems.s;

import com.structure.TreeNode;

public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return root == null ? 0 : solve(0, root);
    }

    int solve(int base, TreeNode node) {
        int curr = base * 10 + node.val;
        if (node.left != null && node.right != null) {
            return solve(curr, node.left) + solve(curr, node.right);
        } else if (node.left != null) {
            return solve(curr, node.left);
        } else if (node.right != null) {
            return solve(curr, node.right);
        } else {
            return curr;
        }
    }
}
