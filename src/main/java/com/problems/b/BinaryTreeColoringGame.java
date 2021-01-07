package com.problems.b;

import com.structure.TreeNode;

public class BinaryTreeColoringGame {

    int left, right;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        int p = n - left - right - 1;
        int max = Math.max(left, right);
        max = Math.max(max, p);
        return max > n - max;
    }

    int dfs(TreeNode node, int x) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left, x);
        int r = dfs(node.right, x);
        if (node.val == x) {
            left = l;
            right = r;
        }
        return 1 + l + r;
    }
}
