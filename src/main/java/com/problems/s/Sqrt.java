package com.problems.s;

public class Sqrt {

    public int mySqrt(int x) {
        if (x >= 46340 * 46340) {
            return 46340;
        }
        int left = 0, right = 46340;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (mid * mid < x) {
                left = mid;
            } else if (mid * mid > x) {
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}
