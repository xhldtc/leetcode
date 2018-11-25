package com.problems.p;

import com.structure.ListNode;

/**
 * @author xhldtc on 25/11/2018.
 */
public class PalindromeLinkedList {

    /**
     * 思路：先找出中间节点，再反转后半部分链表，遍历对比
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode first = head;
        ListNode second = head;
        ListNode half;
        while (second != null) {
            if (second.next == null) {
                break;
            }
            first = first.next;
            second = second.next.next;
        }
        half = first;
        half = reverseList(half);
        while (half != null) {
            if (half.val != head.val) {
                return false;
            }
            half = half.next;
            head = head.next;
        }
        return true;
    }

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
}
