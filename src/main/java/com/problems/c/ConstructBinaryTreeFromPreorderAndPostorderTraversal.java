package com.problems.c;

import com.structure.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return build(pre, post, 0, pre.length, 0, post.length);
    }

    TreeNode build(int[] pre, int[] post, int s1, int e1, int s2, int e2) {
        if (s1 == e1) {
            return null;
        } else if (s1 + 1 == e1) {
            return new TreeNode(pre[s1]);
        }
        TreeNode node = new TreeNode(pre[s1]);
        int num = pre[s1 + 1], index = s2;
        while (post[index] != num) {
            index++;
        }
        int len = index - s2 + 1;
        node.left = build(pre, post, s1 + 1, s1 + 1 + len, s2, s2 + len);
        node.right = build(pre, post, s1 + 1 + len, e1, s2 + len, e2 - 1);
        return node;
    }
}
