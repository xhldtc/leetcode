package com.problems.f;

import com.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElementsInAContaminatedBinaryTree {

    Set<Integer> set = new HashSet<>();

    public FindElementsInAContaminatedBinaryTree(TreeNode root) {
        root.val = 0;
        dfs(root, set);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

    void dfs(TreeNode node, Set<Integer> set) {
        int val = node.val;
        set.add(val);
        if (node.left != null) {
            node.left.val = 2 * val + 1;
            dfs(node.left, set);
        }
        if (node.right != null) {
            node.right.val = 2 * val + 2;
            dfs(node.right, set);
        }
    }
}
