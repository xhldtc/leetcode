package com.problems.f;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {

    private int n;
    AtomicInteger ai = new AtomicInteger(0);
    Semaphore main = new Semaphore(0);
    Semaphore fizz = new Semaphore(0);
    Semaphore buzz = new Semaphore(0);
    Semaphore fizzbuzz = new Semaphore(0);

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (ai.get() <= n) {
            fizz.acquire();
            if (ai.get() > n)
                break;
            printFizz.run();
            main.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (ai.get() <= n) {
            buzz.acquire();
            if (ai.get() > n)
                break;
            printBuzz.run();
            main.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (ai.get() <= n) {
            fizzbuzz.acquire();
            if (ai.get() > n)
                break;
            printFizzBuzz.run();
            main.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (ai.incrementAndGet() <= n) {
            int i = ai.get();
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.release();
                main.acquire();
            } else if (i % 3 == 0) {
                fizz.release();
                main.acquire();
            } else if (i % 5 == 0) {
                buzz.release();
                main.acquire();
            } else {
                printNumber.accept(i);
            }
        }
        fizzbuzz.release();
        fizz.release();
        buzz.release();
    }

    public static void main(String[] args) {
        FizzBuzzMultithreaded fizzbuzz = new FizzBuzzMultithreaded(18);
        new Thread(() -> {
            try {
                fizzbuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzbuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzbuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzbuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
