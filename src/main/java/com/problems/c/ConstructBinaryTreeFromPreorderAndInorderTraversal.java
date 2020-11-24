package com.problems.c;

import com.structure.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        int val = preorder[0];
        TreeNode node = new TreeNode(val);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val)
                index = i;
        }
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
    }
}
