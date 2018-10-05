package com.problems.r;

public class RomanToInteger {

    public int romanToInt(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int ch = s.charAt(i);
            if (ch == 'I') {
                result += 1;
            } else if (ch == 'V') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                    result += 4;
                    i--;
                } else {
                    result += 5;
                }
            } else if (ch == 'X') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'I') {
                    result += 9;
                    i--;
                } else {
                    result += 10;
                }
            } else if (ch == 'L') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                    result += 40;
                    i--;
                } else {
                    result += 50;
                }
            } else if (ch == 'C') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'X') {
                    result += 90;
                    i--;
                } else {
                    result += 100;
                }
            } else if (ch == 'D') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                    result += 400;
                    i--;
                } else {
                    result += 500;
                }
            } else if (ch == 'M') {
                if (i - 1 >= 0 && s.charAt(i - 1) == 'C') {
                    result += 900;
                    i--;
                } else {
                    result += 1000;
                }
            }
        }
        return result;
    }
}
