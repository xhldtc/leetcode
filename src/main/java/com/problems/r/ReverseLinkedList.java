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

    public ListNode reverseList2(ListNode head) {
        ListNode curr = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = curr;
            curr = head;
            head = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        ListNode result = new ReverseLinkedList().reverseList2(l);
        System.out.println(result);
    }
}
