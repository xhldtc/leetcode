package com.problems.a;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return Collections.emptyList();
        }
        TreeNode root = new TreeNode(0);
        List<List<TreeNode>> mem = new ArrayList<>(N + 1);
        mem.add(Collections.emptyList());
        mem.add(Collections.singletonList(root));
        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) {
                mem.add(Collections.emptyList());
                continue;
            }
            List<TreeNode> res = new ArrayList<>();
            for (int left = 1; left <= i - 2; left++) {
                int right = i - 1 - left;
                List<TreeNode> L = mem.get(left);
                List<TreeNode> R = mem.get(right);
                for (TreeNode x : L) {
                    for (TreeNode y : R) {
                        TreeNode tmp = new TreeNode(0);
                        tmp.left = x;
                        tmp.right = y;
                        res.add(tmp);
                    }
                }
            }
            mem.add(res);
        }
        return mem.get(N);
    }
}
