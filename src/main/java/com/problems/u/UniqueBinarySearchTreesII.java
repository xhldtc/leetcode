package com.problems.u;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        int[] src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = i + 1;
        }
        return solve(src, 0, n);
    }

    List<TreeNode> solve(int[] src, int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start == end) {
            res.add(null);
        } else if (start + 1 == end) {
            TreeNode node = new TreeNode(src[start]);
            res.add(node);
        } else {
            for (int i = start; i < end; i++) {
                List<TreeNode> left = solve(src, start, i);
                List<TreeNode> right = solve(src, i + 1, end);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode node = new TreeNode(src[i]);
                        node.left = l;
                        node.right = r;
                        res.add(node);
                    }
                }
            }
        }
        return res;
    }
}
