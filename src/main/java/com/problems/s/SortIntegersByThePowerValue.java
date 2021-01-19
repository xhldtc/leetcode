package com.problems.s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortIntegersByThePowerValue {

    public int getKth(int lo, int hi, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            list.add(new int[]{i, power(i)});
        }
        list.sort((x, y) -> {
            if (x[1] != y[1]) {
                return Integer.compare(x[1], y[1]);
            } else {
                return Integer.compare(x[0], y[0]);
            }
        });
        return list.get(k - 1)[0];
    }

    int power(int a) {
        int res = 0;
        while (a != 1) {
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = a * 3 + 1;
            }
            res++;
        }
        return res;
    }
}
