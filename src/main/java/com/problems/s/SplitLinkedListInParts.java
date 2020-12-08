package com.problems.s;

import com.structure.ListNode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] arr = new ListNode[k];
        if (root == null) {
            return arr;
        }
        int len = length(root);
        int base = len / k;
        int remain = len % k;
        ListNode curr = root, prev = null;
        for (int i = 0; i < remain; i++) {
            ListNode head = curr;
            for (int j = 0; j < base + 1; j++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            arr[i] = head;
        }
        for (int i = remain; i < k; i++) {
            ListNode head = curr;
            for (int j = 0; j < base; j++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            arr[i] = head;
        }
        return arr;
    }

    int length(ListNode node) {
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
