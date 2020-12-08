package com.problems.m;

import com.structure.ListNode;

public class MergeInBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr = list1, prev = null;
        for (int i = 0; i < a; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = list2;
        for (int i = a; i <= b; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        ListNode append = curr;
        curr = list2;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = append;
        return list1;
    }
}
