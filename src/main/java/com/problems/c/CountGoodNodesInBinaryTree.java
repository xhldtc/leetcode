package com.problems.c;

import com.structure.TreeNode;

public class CountGoodNodesInBinaryTree {

    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            res++;
        }
        int next = Math.max(max, node.val);
        dfs(node.left, next);
        dfs(node.right, next);
    }
}
