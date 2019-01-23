package com.problems.l;

import com.structure.ListNode;

/**
 * @author xhldtc on 2019-01-23.
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode curr = detect(head);
        if (curr == null) {
            return null;
        }
        while (curr != head) {
            curr = curr.next;
            head = head.next;
        }
        return curr;
    }

    private ListNode detect(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
            if (first == second) {
                return first;
            }
        }
        return null;
    }
}
