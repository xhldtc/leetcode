package com.problems.l;

import com.structure.ListNode;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        boolean[] flag = new boolean[10000];
        for (int g : G) {
            flag[g] = true;
        }
        ListNode curr = head;
        boolean contain = false;
        int res = 0;
        while (curr != null) {
            if (flag[curr.val]) {
                contain = true;
            } else {
                if (contain) {
                    res++;
                }
                contain = false;
            }
            curr = curr.next;
        }
        if (contain)
            res++;
        return res;
    }
}
