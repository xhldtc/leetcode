package com.problems.v;

import java.util.Stack;

public class VerifyPreorderSerializationOfBinaryTree {

    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        String[] nodes = preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodes.length; i++) {
            String node = nodes[i];
            if (node.equals("#")) {
                if (stack.isEmpty()) {
                    return false;
                }
                while (!stack.isEmpty()) {
                    if (stack.peek() == 2) {
                        stack.pop();
                        stack.push(1);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            } else {
                stack.push(2);
            }
            if (i != nodes.length - 1 && stack.isEmpty()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
