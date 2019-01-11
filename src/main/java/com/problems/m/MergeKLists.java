package com.problems.m;

import com.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xhldtc on 2019-01-11.
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(l -> l.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }
        ListNode head = null, curr = null;
        while (!queue.isEmpty()) {
            ListNode listNode = queue.poll();
            if (curr == null) {
                curr = new ListNode(listNode.val);
                head = curr;
            } else {
                curr.next = new ListNode(listNode.val);
                curr = curr.next;
            }
            if (listNode.next != null) {
                queue.offer(listNode.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode result = new MergeKLists().mergeKLists(new ListNode[]{l1, l2, l3});
        System.out.println(result);
    }
}
