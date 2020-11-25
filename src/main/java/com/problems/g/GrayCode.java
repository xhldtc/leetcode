package com.problems.g;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        } else if (n == 1) {
            res.add(0);
            res.add(1);
            return res;
        } else {
            res.add(0);
            res.add(1);
            for (int i = 1; i < n; i++) {
                int end = res.size() - 1;
                for (int j = end; j >= 0; j--) {
                    res.add((1 << i) | res.get(j));
                }
            }
            return res;
        }
    }
}
