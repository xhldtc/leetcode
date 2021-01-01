package com.problems.l;

import com.structure.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    Pair dfs(TreeNode node) {
        if (node == null) {
            return new Pair(node, 0);
        }
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        if (left.depth == right.depth) {
            return new Pair(node, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else {
            return new Pair(right.node, right.depth + 1);
        }
    }

    static class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
