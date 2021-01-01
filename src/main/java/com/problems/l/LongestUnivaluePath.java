package com.problems.l;

import com.structure.TreeNode;
import com.util.TreeUtils;

public class LongestUnivaluePath {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        }
        int res = 0, curr = 1;
        int left = dfs(node.left);
        if (node.left != null && node.val == node.left.val) {
            res += left;
            curr = left + 1;
        }
        int right = dfs(node.right);
        if (node.right != null && node.val == node.right.val) {
            res += right;
            curr = Math.max(curr, right + 1);
        }
        max = Math.max(max, res);
        return curr;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2]");
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }
}
