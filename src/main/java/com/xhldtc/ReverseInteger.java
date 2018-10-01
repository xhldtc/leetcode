package com.xhldtc;

public class ReverseInteger {

    public int reverse(int x) {
        int y = solve(x);
        if (x % 10 != 0 && solve(y) != x) {
            return 0;
        }
        return y;
    }

    public int solve(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
