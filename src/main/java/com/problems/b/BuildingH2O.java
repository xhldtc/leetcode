package com.problems.b;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class BuildingH2O {

    Semaphore o = new Semaphore(2);
    Semaphore h = new Semaphore(2);

    public BuildingH2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        h.release(2);
    }

    public static void main(String[] args) throws InterruptedException {
        BuildingH2O b = new BuildingH2O();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    b.hydrogen(() -> System.out.print('H'));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    b.oxygen(() -> System.out.print('O'));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
