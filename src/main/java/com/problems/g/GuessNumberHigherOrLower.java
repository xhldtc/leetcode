package com.problems.g;

/**
 * @author xhldtc on 2019-01-01.
 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (true) {
            int mid = (right - left) / 2 + left;
            if (guess(mid) < 0) {
                right = mid - 1;
            } else if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
    }

    private int guess(int num) {
        return 0;
    }
}
