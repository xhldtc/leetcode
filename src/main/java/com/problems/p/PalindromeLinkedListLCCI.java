package com.problems.p;

import com.structure.ListNode;

public class PalindromeLinkedListLCCI {

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode empty = new ListNode(0);
        return solve(head, head, empty) != empty;
    }

    ListNode solve(ListNode curr, ListNode compare, ListNode empty) {
        if(curr.next == null){
            return curr.val == compare.val ? compare.next : empty;
        } else {
            ListNode node = solve(curr.next, compare, empty);
            return (node != empty && curr.val == node.val) ? node.next : empty;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(new PalindromeLinkedListLCCI().isPalindrome(head));
    }
}
