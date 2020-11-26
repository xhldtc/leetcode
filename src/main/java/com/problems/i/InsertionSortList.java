package com.problems.i;

import com.structure.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head.next, dummy = new ListNode(0), next, prev, currNew;
        dummy.next = head;
        head.next = null;
        while (curr != null) {
            next = curr.next;
            prev = dummy;
            currNew = dummy.next;
            while (currNew != null) {
                if (curr.val < currNew.val) {
                    prev.next = curr;
                    curr.next = currNew;
                    break;
                }
                prev = currNew;
                currNew = currNew.next;
            }
            if (currNew == null) {
                prev.next = curr;
                curr.next = null;
            }
            curr = next;
        }
        return dummy.next;
    }
}
