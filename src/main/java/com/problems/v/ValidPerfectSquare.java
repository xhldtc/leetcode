package com.problems.v;

/**
 * @author xhldtc on 2018-12-31.
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num > 46340 * 46340) {
            return false;
        } else if (num == 1 || num == 46340 * 46340) {
            return true;
        } else {
            return find(1, 46340, num);
        }
    }

    private boolean find(int left, int right, int num) {
        if (left + 1 >= right) {
            return false;
        }
        int mid = (left + right) / 2;
        if (num > mid * mid) {
            return find(mid, right, num);
        } else if (num < mid * mid) {
            return find(left, mid, num);
        } else {
            return true;
        }
    }
}
