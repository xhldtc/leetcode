package com.problems.l;

import com.structure.ListNode;
import com.structure.TreeNode;

import java.util.HashMap;

public class LinkedListInBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (dfs(head, root)) {
            return true;
        } else {
            return isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }

    boolean dfs(ListNode listNode, TreeNode treeNode) {
        if (listNode == null) {
            return true;
        }
        if (treeNode == null) {
            return false;
        }
        if (listNode.val == treeNode.val) {
            return dfs(listNode.next, treeNode.left) || dfs(listNode.next, treeNode.right);
        }
        return false;
    }
}
