package com.problems.a;

public class AddBinary {

    public String addBinary(String a, String b) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        while (i < a.length() || i < b.length()) {
            int i1 = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int i2 = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            int res = i1 + i2 + prev;
            if (res == 0) {
                sb.append('0');
                prev = 0;
            } else if (res == 1) {
                sb.append('1');
                prev = 0;
            } else if (res == 2) {
                sb.append('0');
                prev = 1;
            } else if (res == 3) {
                sb.append('1');
                prev = 1;
            }
            i++;
        }
        if (prev == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
