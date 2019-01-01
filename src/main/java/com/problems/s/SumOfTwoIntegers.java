package com.problems.s;

/**
 * @author xhldtc on 2019-01-01.
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else {
            while (b != 0) {
                int carry = a & b;
                a = a ^ b;
                b = carry << 1;
            }
            return a;
        }
    }
}
