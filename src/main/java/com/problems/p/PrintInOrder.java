package com.problems.p;

import java.util.concurrent.CountDownLatch;

public class PrintInOrder {

    CountDownLatch a = new CountDownLatch(1);
    CountDownLatch b = new CountDownLatch(1);

    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        a.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        a.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        b.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        b.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
