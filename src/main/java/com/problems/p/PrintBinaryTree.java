package com.problems.p;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        int d = dfs(root, 0);
        int len = 0;
        for (int i = 0; i < d; i++) {
            len = len * 2 + 1;
        }
        List<List<String>> res = new ArrayList<>(d);
        for (int i = 0; i < d; i++) {
            res.add(new ArrayList<>(Collections.nCopies(len, "")));
        }
        solve(root, 0, len / 2, len, res);
        return res;
    }

    void solve(TreeNode node, int depth, int index, int len, List<List<String>> res) {
        if (node == null) {
            return;
        }
        res.get(depth).set(index, String.valueOf(node.val));
        int diff = (len + 1) / 4;
        solve(node.left, depth + 1, index - diff, len / 2, res);
        solve(node.right, depth + 1, index + diff, len / 2, res);
    }

    int dfs(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(dfs(node.left, depth + 1), dfs(node.right, depth + 1));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new PrintBinaryTree().printTree(root));
    }
}
