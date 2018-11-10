package com.problems.n;

/**
 * @author xhldtc on 10/11/2018.
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += n & 1;
            n >>>= 1;
        }
        return sum;
    }
}
