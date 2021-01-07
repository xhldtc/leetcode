package com.problems.s;

import java.util.PriorityQueue;

public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Integer::compare);
        q.offer(1);
        int prev = 0, a=0;
        for (int i = 0; i < n; i++) {
            a = q.poll();
            if (a == prev) {
                i--;
                continue;
            }
            prev = a;
            System.out.println(a);
            for (int p : primes) {
                q.offer(p * a);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
