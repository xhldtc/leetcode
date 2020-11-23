package com.problems.f;

import com.structure.TreeNode;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        helper(root);
    }

    TreeNode helper(TreeNode node) {
        if (node == null)
            return null;
        if (node.left != null) {
            TreeNode right = node.right;
            TreeNode flatten = helper(node.left);
            flatten.right = right;
            node.right = node.left;
            node.left = null;
            return right != null ? helper(right) : flatten;
        } else if (node.right != null) {
            return helper(node.right);
        } else
            return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = null;
//        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println();
    }
}
