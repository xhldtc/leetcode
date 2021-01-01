package com.problems.m;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {

    List<Integer> list = new ArrayList<>();
    int max = 1;

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return list.isEmpty() ? 0 : max;
    }

    void dfs(TreeNode node ,int depth, int index) {
        if(node == null) {
            return;
        }
        if(list.size() < depth) {
            list.add(index);
        } else {
            max = Math.max(index - list.get(depth - 1) + 1, max);
        }
        dfs(node.left, depth + 1, index * 2 + 1);
        dfs(node.right, depth + 1, index * 2 + 2);
    }
}
