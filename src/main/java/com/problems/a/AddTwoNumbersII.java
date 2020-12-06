package com.problems.a;

import com.structure.ListNode;

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1), len2 = length(l2);
        ListNode longer = len1 > len2 ? l1 : l2;
        ListNode shorter = len1 > len2 ? l2 : l1;
        ListNode res = solve(longer, shorter, Math.abs(len1 - len2));
        if (res.val > 9) {
            ListNode head = new ListNode(res.val / 10);
            res.val %= 10;
            head.next = res;
            res = head;
        }
        return res;
    }

    ListNode solve(ListNode longer, ListNode shorter, int index) {
        if (longer == null) {
            return null;
        }
        ListNode curr = solve(longer.next, index > 0 ? shorter : shorter.next, index - 1);
        int add = 0;
        if (curr != null && curr.val > 9) {
            add = curr.val / 10;
            curr.val %= 10;
        }
        int newVal = longer.val + add + (index > 0 ? 0 : shorter.val);
        ListNode newNode = new ListNode(newVal);
        newNode.next = curr;
        return newNode;
    }

    int length(ListNode list) {
        int len = 0;
        ListNode curr = list;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}
