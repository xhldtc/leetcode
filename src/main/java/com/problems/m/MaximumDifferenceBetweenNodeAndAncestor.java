package com.problems.m;

import com.structure.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {

    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return res;
    }

    int[] dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new int[]{node.val, node.val};
        } else if (node.left == null) {
            int[] right = dfs(node.right);
            res = Math.max(res, Math.abs(node.val - right[0]));
            res = Math.max(res, Math.abs(node.val - right[1]));
            return new int[]{Math.min(right[0], node.val), Math.max(right[1], node.val)};
        } else if (node.right == null) {
            int[] left = dfs(node.left);
            res = Math.max(res, Math.abs(node.val - left[0]));
            res = Math.max(res, Math.abs(node.val - left[1]));
            return new int[]{Math.min(left[0], node.val), Math.max(left[1], node.val)};
        } else {
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            int[] tmp = new int[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])};
            res = Math.max(res, Math.abs(node.val - tmp[0]));
            res = Math.max(res, Math.abs(node.val - tmp[1]));
            return new int[]{Math.min(tmp[0], node.val), Math.max(tmp[1], node.val)};
        }
    }
}
