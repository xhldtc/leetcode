package com.problems.f;

import java.util.Stack;

public class FlattenMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(), curr = head, prev = dummy;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            prev.next = curr;
            curr.prev = prev;
            prev = curr;
            if (curr.child == null) {
                curr = curr.next;
            } else {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr = curr.child;
                prev.child = null;
            }
            if (curr == null && !stack.isEmpty()) {
                curr = stack.pop();
            }
        }
        dummy.next.prev = null;
        return dummy.next;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

}
