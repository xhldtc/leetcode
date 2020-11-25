package com.problems.r;

import com.structure.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int len = 0;
        ListNode curr = head, prev = null;
        while (curr != null) {
            len++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = head;
        int step = len - k % len;
        curr = head;
        while (step-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return curr;
    }
}
