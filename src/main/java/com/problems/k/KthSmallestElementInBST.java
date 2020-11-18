package com.problems.k;

import com.structure.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        AtomicInteger at = new AtomicInteger();
        int[] res = new int[1];
        search(root, at, k, res);
        return res[0];
    }

    void search(TreeNode node, AtomicInteger depth, int k, int[] res) {
        if (node == null || res[0] != 0)
            return;
        search(node.left, depth, k, res);
        if (depth.incrementAndGet() == k) {
            res[0] = node.val;
        }
        search(node.right, depth, k, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);

        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(new KthSmallestElementInBST().kthSmallest(root, 3));

    }
}
