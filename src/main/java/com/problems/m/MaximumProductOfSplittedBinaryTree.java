package com.problems.m;

import com.structure.TreeNode;
import com.util.TreeUtils;

public class MaximumProductOfSplittedBinaryTree {

    public int maxProduct(TreeNode root) {
        int total = calcSum(root);
        int mod = 1000000007;
        return (int) dfs(root, total, mod);
    }

    long dfs(TreeNode node, int total, int mod) {
        long res = 0;
        if (node.left != null) {
            long tmp = node.left.val * (long) (total - node.left.val);
            res = Math.max(tmp, dfs(node.left, total, mod));
        }
        if (node.right != null) {
            long tmp = node.right.val * (long) (total - node.right.val);
            res = Math.max(tmp, res);
            res = Math.max(res, dfs(node.right, total, mod));
        }
        return res;
    }

    int calcSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = calcSum(node.left);
        int right = calcSum(node.right);
        node.val += left + right;
        return node.val;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree("[1,2,3,4,5,6]");
        System.out.println(new MaximumProductOfSplittedBinaryTree().maxProduct(root));
    }
}
