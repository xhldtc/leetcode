package com.problems.d;

public class DesignFrontMiddleBackQueue {

    Node dummy = new Node(0);
    Node head = null;
    Node tail = null;
    Node middle = null;
    int size = 0;

    public DesignFrontMiddleBackQueue() {

    }

    public void pushFront(int val) {
        Node node = new Node(val);
        dummy.next = node;
        node.prev = dummy;
        if(head !=null){
            node.next = head;
            head.prev = node;
            middle = odd() ? middle.prev : middle;
        } else {
            tail = node;
            middle = node;
        }
        head = node;
        size++;
    }

    public void pushMiddle(int val) {
        if(middle == null){
            pushFront(val);
        } else {
            Node node = new Node(val);
            if(odd()){
                Node prev = middle.prev;
                prev.next = node;
                middle.prev = node;
                node.prev = prev;
                node.next = middle;
            } else {
                Node next = middle.next;
                middle.next = node;
                next.prev = node;
                node.prev = middle;
                node.next = next;
            }
            middle = node;
            head = dummy.next;
            size++;
        }
    }

    public void pushBack(int val) {
        Node node = new Node(val);
        if(tail !=null){
            tail.next = node;
            node.prev = tail;
            tail = node;
            middle = odd() ? middle : middle.next;
            size++;
        } else {
            pushFront(val);
        }
    }

    public int popFront() {
        if(head == null)
            return -1;
        int val = head.val;
        if(head.next == null){
            dummy.next = null;
            head.prev = null;
            head = null;
            tail = null;
            middle = null;
        } else {
            dummy.next = head.next;
            head.next.prev = dummy;
            middle = odd() ? middle : middle.next;
            head.prev = null;
            head.next = null;
            head = dummy.next;

        }
        size--;
        return val;
    }

    public int popMiddle() {
        if(middle == null){
            return -1;
        }
        int val = middle.val;
        Node prev = middle.prev;
        Node next = middle.next;
        middle.prev = null;
        middle.next = null;
        prev.next = next;
        if(next != null){
            next.prev = prev;
        }
        if(size == 1){
            middle = null;
            head = null;
            tail = null;
        } else {
            middle = odd() ? prev : next;
            head = dummy.next;
        }
        size--;
        return val;
    }

    public int popBack() {
        if(tail == null)
            return -1;
        int val = tail.val;
        if(tail.prev == dummy){
            tail.prev = null;
            dummy.next = null;
            tail = null;
            head = null;
            middle = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
            tail.next = null;
            middle = odd() ? middle.prev : middle;
        }
        size--;
        return val;
    }

    boolean odd(){
        return (size & 1) ==1;
    }

    static class Node {
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        DesignFrontMiddleBackQueue d = new DesignFrontMiddleBackQueue();
        d.pushMiddle(874835);
        d.popBack();
        d.popMiddle();
        d.popMiddle();
        d.pushBack(319750);
        d.pushFront(782168);
        d.popFront();
        d.pushMiddle(16473);
        d.pushMiddle(495349);
        d.popMiddle();
        d.popMiddle();
        d.pushMiddle(596131);
        d.popMiddle();
        d.pushMiddle(583563);
    }
}
