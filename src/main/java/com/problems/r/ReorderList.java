package com.problems.r;

import com.structure.ListNode;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head, prev = null, mid;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            mid = slow;
            prev.next = null;
        } else {
            mid = slow.next;
            slow.next = null;
        }
        mid = reverse(mid);
        ListNode first = head, second = mid, temp = new ListNode(0), next;
        while (first != null) {
            next = first.next;
            temp.next = first;
            first.next = second;
            temp = second;
            first = next;
            if (second != null)
                second = second.next;
        }
    }

    ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0), curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;
    }
}
