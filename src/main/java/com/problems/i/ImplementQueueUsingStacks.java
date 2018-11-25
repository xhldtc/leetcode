package com.problems.i;

import java.util.Stack;

/**
 * @author xhldtc on 25/11/2018.
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
