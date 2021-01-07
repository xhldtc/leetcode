package com.problems.n;

import com.structure.TreeNode;
import com.util.TreeUtils;

public class NumberOfGoodLeafNodesPairs {

    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    int[] dfs(TreeNode node, int distance) {
        if (node == null) {
            return new int[11];
        }
        if (node.left == null && node.right == null) {
            int[] a = new int[11];
            a[0] = 1;
            return a;
        }
        int[] left = dfs(node.left, distance);
        int[] right = dfs(node.right, distance);
        for (int i = 10; i >= 1; i--) {
            left[i] = left[i - 1];
        }
        left[0] = 0;
        for (int i = 10; i >= 1; i--) {
            right[i] = right[i - 1];
        }
        right[0] = 0;
        for (int i = 1; distance - i > 0; i++) {
            for (int j = 1; i + j <= distance; j++) {
                res += left[i] * right[j];
            }
        }
        int[] ret = new int[left.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = left[i] + right[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree("[1,1,1]");
        System.out.println(new NumberOfGoodLeafNodesPairs().countPairs(root, 2));
    }
}
