package com.problems.p;

import com.structure.ListNode;

public class PartitionListLCCI {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0), small = smallHead;
        ListNode largeHead = new ListNode(0), large = largeHead;
        ListNode curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = null;
            if (curr.val < x) {
                small.next = curr;
                small = curr;
            } else {
                large.next = curr;
                large = curr;
            }
            curr = next;
        }
        small.next = largeHead.next;
        return smallHead.next;
    }
}
