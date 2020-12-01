package com.problems.i;

public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int d = num / 1000;
        if (d != 0) {
            res.append(repeat('M', d));
        }
        d = (num / 100) % 10;
        if (d != 0) {
            if (d < 5) {
                res.append(d != 4 ? repeat('C', d) : "CD");
            } else {
                res.append(d != 9 ? "D" + repeat('C', d - 5) : "CM");
            }
        }
        d = (num / 10) % 10;
        if (d != 0) {
            if (d < 5) {
                res.append(d != 4 ? repeat('X', d) : "XL");
            } else {
                res.append(d != 9 ? "L" + repeat('X', d - 5) : "XC");
            }
        }
        d = num % 10;
        if (d != 0) {
            if (d < 5) {
                res.append(d != 4 ? repeat('I', d) : "IV");
            } else {
                res.append(d != 9 ? "V" + repeat('I', d - 5) : "IX");
            }
        }
        return res.toString();
    }

    String repeat(char ch, int c) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < c; i++) {
            res.append(ch);
        }
        return res.toString();
    }
}
