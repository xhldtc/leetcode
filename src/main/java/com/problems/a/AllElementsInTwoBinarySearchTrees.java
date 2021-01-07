package com.problems.a;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        dfs(root1, a);
        dfs(root2, b);
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < a.size() || j < b.size()) {
            if (i < a.size() && j < b.size()) {
                if (a.get(i) < b.get(j)) {
                    res.add(a.get(i++));
                } else {
                    res.add(b.get(j++));
                }
            } else if (i < a.size()) {
                res.add(a.get(i++));
            } else {
                res.add(b.get(j++));
            }
        }
        return res;
    }

    void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
