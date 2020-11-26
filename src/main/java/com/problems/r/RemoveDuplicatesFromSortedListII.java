package com.problems.r;

import com.structure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> all = new HashSet<>(), dup = new HashSet<>();
        ListNode curr = head, dummy = new ListNode(0);
        dummy.next = head;
        while (curr != null) {
            if (all.contains(curr.val)) {
                dup.add(curr.val);
            } else {
                all.add(curr.val);
            }
            curr = curr.next;
        }
        ListNode prev = dummy, temp;
        curr = dummy.next;
        while (curr != null) {
            if (dup.contains(curr.val)) {
                prev.next = curr.next;
                temp = curr;
                curr = curr.next;
                temp.next = null;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
