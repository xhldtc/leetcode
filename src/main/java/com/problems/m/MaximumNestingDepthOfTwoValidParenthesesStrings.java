package com.problems.m;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {

    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int a = 0, b = 0, i = 0;
        for (char ch : seq.toCharArray()) {
            if (ch == '(') {
                if (a < b) {
                    a++;
                    res[i++] = 0;
                } else {
                    b++;
                    res[i++] = 1;
                }
            } else {
                if (a > b) {
                    a--;
                    res[i++] = 0;
                } else {
                    b--;
                    res[i++] = 1;
                }
            }
        }
        return res;
    }
}
