package com.problems.r;

/**
 * @author xhldtc on 2019-01-01.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr1 = count(ransomNote);
        int[] arr2 = count(magazine);
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] < arr1[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] count(String s) {
        int[] result = new int[26];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (char ch : s.toCharArray()) {
            result[ch - 'a']++;
        }
        return result;
    }
}
