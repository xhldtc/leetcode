package com.problems.r;

import com.structure.ListNode;

/**
 * @author xhldtc on 23/11/2018.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val == val) {
                if (prev == null) {
                    curr = curr.next;
                    head = curr;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    curr = prev.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
