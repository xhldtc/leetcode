package com.problems.o;

import com.structure.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode even = head.next, prev = head, curr = head.next, pp = null;
        boolean odd = true;
        while (curr != null) {
            prev.next = curr.next;
            pp = prev;
            prev = curr;
            curr = curr.next;
            odd = !odd;
        }
        if (odd) {
            prev.next = even;
        } else {
            pp.next = even;
        }
        return head;
    }
}
