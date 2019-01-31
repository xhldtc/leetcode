package com.problems.r;

import com.structure.ListNode;

/**
 * @author xhldtc on 2019-01-31.
 * 快的指针先走n步，然后慢的指针开始一起走，快的指针到头之后，慢指针就是要删除的节点
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        while (--n > 0) {
            front = front.next;
        }
        ListNode back = head, prev = null;
        while (front.next != null) {
            prev = back;
            front = front.next;
            back = back.next;
        }
        if (prev == null) {
            return head.next;
        } else {
            prev.next = back.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1);
        System.out.println(head);
    }
}
