package com.problems.n;

import com.structure.ListNode;

import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        int len =0;
        while(curr != null){
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && curr.val > stack.peek().val) {
                    ListNode node = stack.pop();
                    node.val = curr.val;
                }
            }
            stack.push(curr);
            curr = curr.next;
            len++;
        }
        while(!stack.isEmpty()){
            stack.pop().val = 0;
        }
        curr = head;
        int[] res = new int[len];
        int index = 0;
        while(curr != null){
            res[index++] = curr.val;
            curr = curr.next;
        }
        return res;
    }
}
