package com.problems.e;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int sum = 0, power = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += (s.charAt(i) - 'A' + 1) * power;
            power *= 26;
        }
        return sum;
    }
}
