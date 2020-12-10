package com.problems.r;

import com.structure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        ListNode curr = head, prev = dummy;
        int sum = 0;
        while(curr != null){
            if(curr.val == 0){
                prev.next = curr.next;
            } else {
                sum += curr.val;
                if(!map.containsKey(sum)){
                    map.put(sum, curr);
                    prev = curr;
                } else {
                    ListNode node = map.get(sum);
                    ListNode temp = node.next;
                    int add = sum;
                    while(temp!=null && temp !=curr){
                        add += temp.val;
                        map.remove(add);
                        temp = temp.next;
                    }
                    node.next = curr.next;
                    prev = node;
                }
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
