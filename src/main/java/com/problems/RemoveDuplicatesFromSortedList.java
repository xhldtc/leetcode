package com.problems;

import com.structure.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (prev != null && curr.val == prev.val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
