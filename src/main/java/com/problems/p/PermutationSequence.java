package com.problems.p;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xhldtc on 2019-01-11.
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int result = 0;
        while (list.size() > 1) {
            int divide = factor(n - 1);
            int index = (k - 1) / divide;
            result = result * 10 + list.get(index);
            list.remove(list.get(index));
            k = k % divide;
            if (k == 0) {
                k = divide;
            }
            n--;
        }
        result = result * 10 + list.get(0);
        return String.valueOf(result);
    }

    private int factor(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
