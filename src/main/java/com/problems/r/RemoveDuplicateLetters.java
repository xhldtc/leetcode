package com.problems.r;

import java.util.Arrays;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        boolean[] flag = new boolean[26];
        int[] end = new int[26];
        Arrays.fill(end, -1);
        for (char ch : s.toCharArray()) {
            flag[ch - 'a'] = true;
        }
        int len = 0;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                len++;
                end[i] = s.lastIndexOf((char) ('a' + i));
            }
        }
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        while (sb.length() < len) {
            for (int i = 0; i < flag.length; i++) {
                if (flag[i]) {
                    int index = s.indexOf(i + 'a', curr);
                    if (match(flag, end, index)) {
                        flag[i] = false;
                        sb.append((char) (i + 'a'));
                        curr = index;
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }

    boolean match(boolean[] flag, int[] end, int index) {
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] && end[i] < index) {
                return false;
            }
        }
        return true;
    }
}
