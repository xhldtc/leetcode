package com.problems.s;

import com.structure.ListNode;

/**
 * @author xhldtc on 2019-02-01.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode prev = null, first = head;
        while (first != null && first.next != null) {
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            if (prev == null) {
                head = second;
            } else {
                prev.next = second;
            }
            prev = first;
            first = first.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = new SwapNodesInPairs().swapPairs(head);
        System.out.println(result);
    }
}
