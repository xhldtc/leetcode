package com.problems.a;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] a) {
        if (a.length < 3) {
            return 0;
        }
        int prevDiff = a[1] - a[0];
        int len = 2, res = 0;
        for (int i = 2; i < a.length; i++) {
            int diff = a[i] - a[i - 1];
            if (diff == prevDiff) {
                len++;
            } else {
                if (len > 2) {
                    res += (len - 1) * (len - 2) / 2;
                }
                len = 2;
            }
            prevDiff = diff;
        }
        res += (len - 1) * (len - 2) / 2;
        return res;
    }
}
