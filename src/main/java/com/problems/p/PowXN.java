package com.problems.p;

public class PowXN {

    public double myPow(double x, int n) {
        boolean negative = n < 0;
        long nc = Math.abs((long) n);
        double res = 1d, curr = x;
        while (nc != 0) {
            long bit = nc & 0x1;
            if (bit == 1) {
                res *= curr;
            }
            curr = curr * curr;
            nc >>= 1;
        }
        return negative ? 1 / res : res;
    }
}
