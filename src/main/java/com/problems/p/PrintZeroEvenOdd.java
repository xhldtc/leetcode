package com.problems.p;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class PrintZeroEvenOdd {

    private int n;
    Semaphore zero = new Semaphore(0);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);
    volatile int i = 1;

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            printNumber.accept(0);
            if (i % 2 == 0)
                even.release();
            else
                odd.release();
            zero.acquire();
            i++;
        }
        odd.release();
        even.release();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            even.acquire();
            if (i > n)
                break;
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            odd.acquire();
            if (i > n)
                break;
            printNumber.accept(i);
            zero.release();
        }
    }
}
