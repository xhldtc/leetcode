package com.problems.d;

/**
 * @author xhldtc on 2019-03-01.
 */
public class DecodeWays {

    private int sum = 0;

    public int numDecodings(String s) {
        dfs(s, 0);
        return sum;
    }

    private void dfs(String s, int index) {
        if (index >= s.length()) {
            sum++;
            return;
        }
        if (s.charAt(index) > '0') {
            dfs(s, index + 1);
            if (index + 1 < s.length()) {
                int num = Integer.valueOf(s.substring(index, index + 2));
                if (num > 0 && num <= 26) {
                    dfs(s, index + 2);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("01"));
    }
}
