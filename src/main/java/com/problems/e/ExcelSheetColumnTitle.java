package com.problems.e;

public class ExcelSheetColumnTitle {


    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int num = n % 26 == 0 ? 26 : n % 26;
            sb.append((char) ('A' + num - 1));
            n = n % 26 == 0 ? n / 26 - 1 : n / 26;
        }
        return sb.reverse().toString();
    }
}
