package com.problems.s;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {
        if (S.length() == 2) {
            return 1;
        }
        int i = 0, c = 0;
        for (i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (ch == '(') {
                c++;
            } else {
                c--;
            }
            if (c == 0) {
                break;
            }
        }
        if (i == S.length() - 1) {
            String s = S.substring(1, S.length() - 1);
            return 2 * scoreOfParentheses(s);
        } else {
            String s = S.substring(0, i + 1);
            String t = S.substring(i + 1);
            return scoreOfParentheses(s) + scoreOfParentheses(t);
        }
    }
}
