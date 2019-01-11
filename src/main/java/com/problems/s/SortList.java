package com.problems.s;

import com.structure.ListNode;

/**
 * @author xhldtc on 2019-01-11.
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode[] couple = splitList(head);
        ListNode first = sortList(couple[0]);
        ListNode second = sortList(couple[1]);
        return mergeTwoLists(first, second);
    }

    private ListNode[] splitList(ListNode listNode) {
        ListNode head = listNode, half = listNode, one = listNode, prev = null;
        while (true) {
            if (one == null || one.next == null) {
                break;
            }
            prev = half;
            half = half.next;
            one = one.next.next;
        }
        prev.next = null;
        return new ListNode[]{head, half};
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
