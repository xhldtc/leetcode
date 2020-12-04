package com.problems.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        Node curr = head, dummy = new Node(0), newCurr = dummy;
        int index = 0;
        while (curr != null) {
            map.put(curr, index++);
            newCurr.next = new Node(curr.val);
            list.add(newCurr.next);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        curr = head;
        newCurr = dummy.next;
        while (curr != null) {
            Node random = curr.random;
            if (random != null) {
                newCurr.random = list.get(map.get(random));
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
