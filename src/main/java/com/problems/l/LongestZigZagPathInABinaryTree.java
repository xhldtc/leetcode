package com.problems.l;

import com.structure.TreeNode;

public class LongestZigZagPathInABinaryTree {

    public int longestZigZag(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    int[] dfs(TreeNode node, int[] res) {
        if (node == null) {
            return new int[]{-1, -1};
        }
        int[] left = dfs(node.left, res);
        int[] right = dfs(node.right, res);

        int[] dp = new int[]{left[1] + 1, right[0] + 1};
        int max =  Math.max(dp[0], dp[1]);
        res[0] = Math.max(res[0], max);
        return dp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(6);
        root.right.right.left.right = new TreeNode(7);
        root.right.right.left.right.right = new TreeNode(8);
        System.out.println(new LongestZigZagPathInABinaryTree().longestZigZag(root));
    }
}
