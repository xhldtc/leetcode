package com.problems.d;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest {

    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        boolean[] flag = new boolean[1001];
        for (int a : to_delete) {
            flag[a] = true;
        }
        root = dfs(root, flag);
        if (root != null) {
            res.add(root);
        }
        return res;
    }

    TreeNode dfs(TreeNode node, boolean[] flag) {
        if (node == null) {
            return null;
        }
        TreeNode left = dfs(node.left, flag);
        TreeNode right = dfs(node.right, flag);
        if (left == null) {
            node.left = null;
        }
        if (right == null) {
            node.right = null;
        }
        if (flag[node.val]) {
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            return null;
        }
        return node;
    }
}
