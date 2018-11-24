package com.problems.r;

import com.structure.ListNode;

/**
 * @author xhldtc on 24/11/2018.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tail = head.next;
        ListNode tailPrev = head;
        while (tail != null) {
            ListNode tailNext = tail.next;
            tailPrev.next = tailNext;
            tail.next = head;
            head = tail;
            tail = tailNext;
        }
        return head;
    }
}
