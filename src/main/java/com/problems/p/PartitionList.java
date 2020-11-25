package com.problems.p;

import com.structure.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode min = new ListNode(0), max = new ListNode(0);
        ListNode currMin = min, currMax = max, curr = head;
        while (curr != null) {
            int val = curr.val;
            if (val < x) {
                currMin.next = curr;
                currMin = curr;
            } else {
                currMax.next = curr;
                currMax = curr;
            }
            curr = curr.next;
        }
        currMax.next = null;
        currMin.next = max.next;
        return min.next;
    }
}
