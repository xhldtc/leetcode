package com.problems.d;

import java.util.Arrays;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        if (dividend == 0)
            return 0;
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        boolean isMin = dividend == Integer.MIN_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        dividend = isMin ? Integer.MAX_VALUE : Math.abs(dividend);
        divisor = Math.abs(divisor);

        int base = 0;
        while (dividend >= divisor) {
            int[] pair = help(dividend, divisor);
            dividend = pair[0];
            base += pair[1];
        }
        if (dividend + 1 == divisor && isMin)
            base++;
        return positive ? base : -base;
    }

    int[] help(int dividend, int divisor) {
        int base = 1;
        while (dividend - divisor >= divisor) {
            divisor <<= 1;
            base <<= 1;
        }
        return new int[]{dividend - divisor, base};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DivideTwoIntegers().help(26, 26)));
        System.out.println(new DivideTwoIntegers().divide(26, 5));
        System.out.println(new DivideTwoIntegers().divide(10, 3));
        System.out.println(new DivideTwoIntegers().divide(7, -3));
        System.out.println(new DivideTwoIntegers().divide(0, 1));
        System.out.println(new DivideTwoIntegers().divide(1, 1));
        System.out.println(new DivideTwoIntegers().divide(Integer.MIN_VALUE, 1));

    }
}
