package com.problems.t;

public class TwoKeysKeyboard {

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int start = n / 2;
        for (int i = start; i > 1; i--) {
            if (n % i == 0) {
                return minSteps(i) + n / i;
            }
        }
        return n;
    }
}
