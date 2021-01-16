package com.problems.d;

public class DesignCircularQueue {

    int k;
    int size = 0;
    int[] a;
    int head = 0;
    int rear = 0;

    public DesignCircularQueue(int k) {
        this.k = k;
        a = new int[k];
    }

    public boolean enQueue(int value) {
        if (size == k) {
            return false;
        }
        a[rear % k] = value;
        rear = (rear + 1) % k;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % k;
        size--;
        return true;
    }

    public int Front() {
        return size == 0 ? -1 : a[head];
    }

    public int Rear() {
        return size == 0 ? -1 : a[rear == 0 ? k - 1 : rear - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
