package com.problems.s;

import com.structure.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {

    int res = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false, false);
        return res;
    }

    void dfs(TreeNode node, boolean parent, boolean pp) {
        if (node == null) {
            return;
        }
        if (pp) {
            res += node.val;
        }
        boolean p = node.val % 2 == 0;
        dfs(node.left, p, parent);
        dfs(node.right, p, parent);
    }
}
