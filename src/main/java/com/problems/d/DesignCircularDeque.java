package com.problems.d;

public class DesignCircularDeque {

    int k;
    int size = 0;
    Node dummy = new Node(0);
    Node last = dummy;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public DesignCircularDeque(int k) {
        this.k = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == k) {
            return false;
        }
        Node front = dummy.next;
        Node tmp = new Node(value);
        dummy.next = tmp;
        tmp.prev = dummy;
        tmp.next = front;
        if (front != null) {
            front.prev = tmp;
        } else {
            last = tmp;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == k) {
            return false;
        }
        Node tmp = new Node(value);
        last.next = tmp;
        tmp.prev = last;
        last = tmp;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        Node front = dummy.next;
        dummy.next = front.next;
        if (size == 1) {
            last = dummy;
        } else {
            front.next.prev = dummy;
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        last.prev.next = null;
        last = last.prev;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return size == 0 ? -1 : dummy.next.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return size == 0 ? -1 : last.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == k;
    }

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
