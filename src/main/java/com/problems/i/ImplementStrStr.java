package com.problems.i;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int index = -1;
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            boolean find = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return i;
            }
        }
        return index;
    }
}
