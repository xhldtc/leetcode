package com.problems.s;

import java.util.Set;
import java.util.TreeSet;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i <= 46340; i++) {
            set.add(i * i);
        }
        for (Integer num : set) {
            if (num > c) {
                break;
            }
            if (set.contains(c - num)) {
                return true;
            }
        }
        return false;
    }
}
