package com.problems.c;

public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sum += 10;
            } else {
                sum += A(10, i) - A(9, i - 1);
            }
        }
        return sum;
    }

    int A(int down, int up) {
        int res = 1;
        for (int i = 0; i < up; i++) {
            res *= (down - i);
        }
        return res;
    }
}
