package com.problems.h;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xhldtc on 23/11/2018.
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = sum(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
        return true;
    }

    public int sum(int num) {
        int result = 0;
        while (num != 0) {
            int d = num % 10;
            result += d * d;
            num /= 10;
        }
        return result;
    }
}
