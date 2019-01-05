package com.problems.n;

/**
 * @author xhldtc on 2019-01-05.
 */
public class NthDigit {

    public int findNthDigit(int n) {
        int digits = 1;
        long size = 0, count = 9;
        while (size < n) {
            int add = (int) (n - size);
            size += digits * count;
            if (size >= n) {
                int index = add / digits;
                int remain = add % digits;
                long num = (count / 9) + index;
                if (remain == 0) {
                    //前一位数的最后一位
                    return getDigit(num - 1, digits);
                } else {
                    return getDigit(num, remain);
                }
            }
            digits++;
            count *= 10;
        }
        return 0;
    }

    private int getDigit(long num, int index) {
        return String.valueOf(num).charAt(index - 1) - '0';
    }
}
