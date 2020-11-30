package com.problems.b;

public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        int hm = highestIndex(m);
        int hn = highestIndex(n);
        if (hm != hn) {
            return 0;
        } else {
            int res = m ^ n;
            int hr = highestIndex(res);
            return m & (Integer.MAX_VALUE << hr);
        }
    }

    int highestIndex(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(10, 11));
    }
}
