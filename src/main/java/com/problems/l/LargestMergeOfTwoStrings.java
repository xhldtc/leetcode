package com.problems.l;

public class LargestMergeOfTwoStrings {

    public String largestMerge(String word1, String word2) {
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        while (x < word1.length() && y < word2.length()) {
            String curr = solve(word1, word2, x, y);
            if (curr == word1) {
                sb.append(word1.charAt(x));
                x++;
            } else {
                sb.append(word2.charAt(y));
                y++;
            }
        }
        if (x < word1.length()) {
            sb.append(word1.substring(x));
        } else if (y < word2.length()) {
            sb.append(word2.substring(y));
        }
        return sb.toString();
    }

    String solve(String s, String t, int x, int y) {
        while (x < s.length() && y < t.length()) {
            char c1 = s.charAt(x);
            char c2 = t.charAt(y);
            if (c1 > c2) {
                return s;
            } else if (c2 > c1) {
                return t;
            } else {
                x++;
                y++;
            }
        }
        if (x < s.length()) {
            return s;
        } else {
            return t;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LargestMergeOfTwoStrings().largestMerge("ddwdddddddddddddwwddddddwddw",
                "wwwwwwwwwddwwdwwwwwwwwwwwwwww"));
    }
}
