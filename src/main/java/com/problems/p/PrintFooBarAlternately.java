package com.problems.p;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintFooBarAlternately {

    private int n;
    Lock lock = new ReentrantLock();
    Condition foo = lock.newCondition();
    Condition bar = lock.newCondition();
    boolean fooPrint = false;
    boolean barPrint = false;

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooPrint = true;
                barPrint = false;
                foo.signal();
                while (!barPrint) {
                    bar.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        lock.lock();
        try {
            for (int i = 0; i < n; i++) {
                while (!fooPrint) {
                    foo.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barPrint = true;
                fooPrint = false;
                bar.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}
