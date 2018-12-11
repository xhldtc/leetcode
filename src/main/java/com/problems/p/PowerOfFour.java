package com.problems.p;

/**
 * @author xhldtc on 11/12/2018.
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        if (num > 0 && (1 << 30) % num == 0) {
            int sqrt = (int) Math.sqrt(num);
            return sqrt * sqrt == num;
        }
        return false;
    }
}
