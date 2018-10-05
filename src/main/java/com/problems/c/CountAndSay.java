package com.problems.c;

public class CountAndSay {

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = next(result);
        }
        return result;
    }

    private String next(String s) {
        int digit = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == digit) {
                count++;
            } else {
                sb.append(String.valueOf(count));
                sb.append((char) digit);
                digit = s.charAt(i);
                count = 1;
            }
        }
        sb.append(String.valueOf(count));
        sb.append((char) digit);
        return sb.toString();
    }
}
