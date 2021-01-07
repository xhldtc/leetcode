package com.problems.p;

import com.structure.TreeNode;

public class PseudoPalindromicPathsInBinaryTree {

    int res = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root, new int[10]);
        return res;
    }

    void dfs(TreeNode node, int[] count) {
        if (node == null) {
            return;
        }
        count[node.val]++;
        if (node.left == null && node.right == null) {
            int odd = 0;
            for (int i = 1; i < 10; i++) {
                if (count[i] % 2 == 1) {
                    odd++;
                }
            }
            if (odd <= 1) {
                res++;
            }
        } else {
            dfs(node.left, count);
            dfs(node.right, count);
        }
        count[node.val]--;
    }
}
