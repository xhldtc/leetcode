package com.problems.s;

public class StringToInteger {

    public int myAtoi(String s) {
        String[] arr = s.trim().split("\\s+");
        if (arr.length == 0) {
            return 0;
        }
        String word = arr[0];
        boolean negative = isNegative(word);
        boolean positive = isPositive(word);
        word = negative || positive ? word.substring(1) : word;
        int index = word.indexOf('.');
        if (index != -1) {
            word = word.substring(0, index);
        }
        String num = removeLeadingZero(parseNumber(word));
        if (num.isEmpty()) {
            return 0;
        }
        if (num.length() > 10) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        long res = negative ? Long.parseLong("-" + num) : Long.parseLong(num);
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }
    }

    public String parseNumber(String s) {
        int index = 0;
        while (index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9')) {
            index++;
        }
        return s.substring(0, index);
    }

    public boolean isNegative(String s) {
        return !s.isEmpty() && s.charAt(0) == '-';
    }

    public boolean isPositive(String s) {
        return !s.isEmpty() && s.charAt(0) == '+';
    }

    public String removeLeadingZero(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        return s.substring(index);
    }
}
