package com.problems.l;

import com.structure.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null) {
                if (curr.next.val == Integer.MAX_VALUE) {
                    return true;
                }
                curr.next.val = Integer.MAX_VALUE;
            }
            curr = curr.next;
        }
        return false;
    }
}
