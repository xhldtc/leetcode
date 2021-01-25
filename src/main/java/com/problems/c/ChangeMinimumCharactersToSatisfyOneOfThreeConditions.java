package com.problems.c;

public class ChangeMinimumCharactersToSatisfyOneOfThreeConditions {

    public int minCharacters(String a, String b) {
        int[] x = new int[26], y = new int[26];
        for (char ch : a.toCharArray()) {
            x[ch - 'a']++;
        }
        for (char ch : b.toCharArray()) {
            y[ch - 'a']++;
        }

        int tmp = Integer.MAX_VALUE;
        for (char ch = 'b'; ch <= 'z'; ch++) {
            tmp = Math.min(solve(x, y, ch), tmp);
            tmp = Math.min(solve(y, x, ch), tmp);
        }

        int max = 0;
        for (int i = 0; i < x.length; i++) {
            x[i] += y[i];
            max = Math.max(max, x[i]);
        }
        int res = a.length() + b.length() - max;
        return Math.min(tmp, res);
    }

    int solve(int[] x, int[] y, char ch) {
        int res = 0;
        for (int i = 0; i + 'a' < ch; i++) {
            res += x[i];
        }
        for (int i = ch - 'a'; i < y.length; i++) {
            res += y[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ChangeMinimumCharactersToSatisfyOneOfThreeConditions().minCharacters("ace", "abe"));
    }
}
