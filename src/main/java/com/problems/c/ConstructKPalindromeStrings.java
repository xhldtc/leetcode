package com.problems.c;

public class ConstructKPalindromeStrings {

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] c = new int[26];
        for (char ch : s.toCharArray()) {
            c[ch - 'a']++;
        }
        int min = 0;
        for (int i = 0; i < c.length; i++) {
            min += c[i] % 2;
        }
        min = min > 0 ? min : 1;
        return k >= min;
    }
}
