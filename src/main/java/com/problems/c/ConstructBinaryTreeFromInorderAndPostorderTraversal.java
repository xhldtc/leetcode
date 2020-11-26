package com.problems.c;

import com.structure.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        int val = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(val);
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val)
                index = i;
        }
        node.left = buildTree(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
        node.right = buildTree(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
        return node;
    }
}
