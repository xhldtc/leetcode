package com.problems.f;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        long sum = 0, factor = 5, num = n;
        while (num >= factor) {
            sum += num / factor;
            factor *= 5;
        }
        return (int) sum;
    }
}
