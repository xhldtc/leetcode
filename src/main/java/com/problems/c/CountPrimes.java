package com.problems.c;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xhldtc on 24/11/2018.
 */
public class CountPrimes {

    private List<Integer> primes = new ArrayList<>();

    public CountPrimes() {
        primes.add(2);
    }

    public int countPrimes(int n) {
        if (n <= primes.get(primes.size() - 1)) {
            int total = 0;
            for (int prime : primes) {
                if (prime < n) {
                    total++;
                } else {
                    break;
                }
            }
            return total;
        } else {
            int start = primes.get(primes.size() - 1);
            for (int num = start + 1; num <= n; num++) {
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
            return n == primes.get(primes.size() - 1) ? primes.size() - 1 : primes.size();
        }
    }

    public boolean isPrime(int num) {
        for (int i = 0; primes.get(i) * primes.get(i) <= num; i++) {
            if (num % primes.get(i) == 0) {
                return false;
            }
        }
        return true;
    }
}
