package com.problems.c;

import com.structure.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length);
    }

    TreeNode build(int[] a, int start, int end) {
        if (start == end) {
            return null;
        }
        TreeNode node = new TreeNode(a[start]);
        int i = start + 1;
        while (i < end && a[i] < a[start]) {
            i++;
        }
        node.left = build(a, start + 1, i);
        node.right = build(a, i, end);
        return node;
    }
}
