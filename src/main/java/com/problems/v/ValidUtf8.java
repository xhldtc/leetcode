package com.problems.v;

/**
 * @author xhldtc on 2019-01-09.
 */
public class ValidUtf8 {

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            if (leadingOne(data[i]) == 0) {
                i++;
            } else {
                int count = leadingOne(data[i]);
                if (count == 1 || count > 4 || i + count > data.length) {
                    return false;
                }
                for (int j = i + 1; j < i + count; j++) {
                    if (leadingOne(data[j]) != 1) {
                        return false;
                    }
                }
                i += count;
            }
        }
        return true;
    }

    private int leadingOne(int num) {
        int mask = 128, count = 0;
        while (mask > 0 && (num & mask) == mask) {
            mask >>>= 1;
            count++;
        }
        return count;
    }
}
