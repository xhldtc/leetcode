package com.problems.s;

public class StringCompression {

    public int compress(char[] chars) {
        if (chars.length == 0) {
            return chars.length;
        }
        char prev = chars[0];
        int index = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == prev) {
                count++;
            } else {
                index = update(chars, prev, index, count);
                count = 1;
            }
            prev = ch;
        }
        return update(chars, prev, index, count);
    }

    int update(char[] chars, char ch, int index, int count) {
        chars[index++] = ch;
        if (count > 1) {
            String s = String.valueOf(count);
            for (int i = 0; i < s.length(); i++) {
                chars[index++] = s.charAt(i);
            }
        }
        return index;
    }
}
