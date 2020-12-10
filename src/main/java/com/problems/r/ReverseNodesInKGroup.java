package com.problems.r;

import com.structure.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), curr = head, prev = dummy;
        dummy.next = head;
        while (curr != null) {
            ListNode start = curr, prevEnd = prev, temp;
            int i;
            for (i = 0; i < k && curr != null; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            if (i == k) {
                temp = reverse(start);
                prevEnd.next = prev;
                prev = temp;
            } else {
                prevEnd.next = start;
            }
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = reverse(head.next);
        temp.next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(head, 2));
    }
}
