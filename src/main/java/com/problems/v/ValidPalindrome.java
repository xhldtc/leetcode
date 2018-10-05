package com.problems.v;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int l = s.charAt(left);
            int r = s.charAt(right);
            if (!isValid(l)) {
                left++;
            } else if (!isValid(r)) {
                right--;
            } else if (l != r) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isValid(int ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z');
    }
}
