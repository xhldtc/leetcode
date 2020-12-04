package com.problems.c;

import com.structure.TreeNode;

import java.util.Arrays;

public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    int dfs(TreeNode node, int rightSum) {
        if (node == null) {
            return rightSum;
        }
        node.val += dfs(node.right, rightSum);
        return node.left != null ? dfs(node.left, node.val) : node.val;
    }

}
