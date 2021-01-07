package com.problems.l;

public class LongestRepeatingCharacterReplacement {

    int[] count = new int[26];
    int res = 1;

    public int characterReplacement(String s, int k) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 1;
        count[s.charAt(0) - 'A']++;
        while (right <= s.length()) {
            while (right <= s.length() && valid(s, left, right, k)) {
                right++;
                if (right - 1 < s.length()) {
                    count[s.charAt(right - 1) - 'A']++;
                }
            }
            while (right <= s.length() && !valid(s, left, right, k)) {
                left++;
                count[s.charAt(left - 1) - 'A']--;
                right++;
                if (right - 1 < s.length()) {
                    count[s.charAt(right - 1) - 'A']++;
                }
            }
        }
        return res;
    }

    boolean valid(String s, int start, int end, int k) {
        int max = 0, total = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
            total += count[i];
        }
        if (k >= total - max) {
            res = Math.max(res, total);
            return true;
        }
        return false;
    }
}
