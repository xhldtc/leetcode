package com.problems.p;

import java.util.Arrays;

/**
 * @author xhldtc on 2019-01-14.
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char ch : s1.toCharArray()) {
            count[ch - 'a']++;
        }
        int[] change = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            change[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count, change)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            char start = s2.charAt(i - s1.length());
            change[start - 'a']--;
            change[s2.charAt(i) - 'a']++;
            if (Arrays.equals(count, change)) {
                return true;
            }
        }
        return false;
    }
}
