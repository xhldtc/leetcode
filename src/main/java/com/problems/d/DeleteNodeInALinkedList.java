package com.problems.d;

import com.structure.ListNode;

/**
 * @author xhldtc on 25/11/2018.
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
