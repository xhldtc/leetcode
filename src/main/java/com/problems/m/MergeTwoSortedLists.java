package com.problems.m;

import com.structure.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    if (current == null) {
                        current = new ListNode(l1.val);
                        result = current;
                    } else {
                        current.next = new ListNode(l1.val);
                        current = current.next;
                    }
                    l1 = l1.next;
                } else if (l2.val < l1.val) {
                    if (current == null) {
                        current = new ListNode(l2.val);
                        result = current;
                    } else {
                        current.next = new ListNode(l2.val);
                        current = current.next;
                    }
                    l2 = l2.next;
                } else {
                    if (current == null) {
                        current = new ListNode(l1.val);
                        current.next = new ListNode(l2.val);
                        result = current;
                        current = current.next;
                    } else {
                        current.next = new ListNode(l1.val);
                        current.next.next = new ListNode(l2.val);
                        current = current.next.next;
                    }
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                current.next = l1;
            } else if (l2 != null) {
                current.next = l2;
            }
            return result;
        }
    }
}
