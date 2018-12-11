package com.problems.p;

/**
 * @author xhldtc on 11/12/2018.
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
