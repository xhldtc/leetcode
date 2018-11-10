package com.problems.r;

/**
 * @author xhldtc on 10/11/2018.
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>>= 1;
        }
        return res;
    }
}
