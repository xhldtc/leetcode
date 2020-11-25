package com.problems.r;

import com.structure.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode curr = head, res = null, tail = null, next, prev = null, end = null;
        for (int i = 1; i <= n; i++) {
            next = curr.next;
            if (i >= m) {
                if (i == m) {
                    end = prev;
                }
                if (res == null) {
                    res = curr;
                    tail = curr;
                } else {
                    curr.next = res;
                    res = curr;
                }
            }
            prev = curr;
            curr = next;
        }
        if (tail != null)
            tail.next = curr;
        if (end != null)
            end.next = res;
        return m == 1 ? res : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseLinkedListII().reverseBetween(head, 1, 2));
    }
}
