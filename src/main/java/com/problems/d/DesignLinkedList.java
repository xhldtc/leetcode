package com.problems.d;

public class DesignLinkedList {

    Node head = null;
    Node tail = null;
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public DesignLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index >= 0 && index <= size) {
            Node node = new Node(val);
            if (size == 0) {
                head = node;
                tail = node;
            } else {
                Node curr = head, prev = null;
                for (int i = 0; i < index; i++) {
                    prev = curr;
                    curr = curr.next;
                }
                if (prev != null) {
                    prev.next = node;
                } else {
                    head = node;
                }
                node.next = curr;
                if (curr == null) {
                    tail = node;
                }
            }
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            Node curr = head, prev = null;
            for (int i = 0; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = curr.next;
            } else {
                head = head.next;
            }
            if (prev != null && prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
