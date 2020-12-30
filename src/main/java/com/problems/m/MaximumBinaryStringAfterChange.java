package com.problems.m;

import java.util.Arrays;

public class MaximumBinaryStringAfterChange {

    public String maximumBinaryString(String binary) {
        int index = binary.indexOf('0');
        if (index < 0) {
            return binary;
        }
        int count = 0;
        char[] chs = new char[binary.length()];
        Arrays.fill(chs, '1');
        for (int i = index + 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }
        chs[binary.length() - count - 1] = '0';
        return new String(chs);
    }
}
