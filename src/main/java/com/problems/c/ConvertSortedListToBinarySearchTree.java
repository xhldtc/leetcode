package com.problems.c;

import com.structure.ListNode;
import com.structure.TreeNode;

/**
 * @author xhldtc on 2019-03-08.
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return build(head);
    }

    private TreeNode build(ListNode head) {
        if (head.next == null) {
            return new TreeNode(head.val);
        } else if (head.next.next == null) {
            TreeNode root = new TreeNode(head.next.val);
            root.left = new TreeNode(head.val);
            return root;
        } else {
            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;
            TreeNode root = new TreeNode(slow.val);
            root.left = build(head);
            root.right = build(slow.next);
            return root;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode root = new ConvertSortedListToBinarySearchTree().build(head);
        System.out.println(root);
    }
}
