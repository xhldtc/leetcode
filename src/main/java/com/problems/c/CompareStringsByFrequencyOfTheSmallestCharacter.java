package com.problems.c;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter {

    int[] c = new int[26];

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[][] q = new int[queries.length][2];
        for (int i = 0; i < q.length; i++) {
            q[i] = new int[]{f(queries[i]), i};
        }
        Arrays.sort(q, (x, y) -> Integer.compare(y[0], x[0]));
        int[] w = new int[words.length];
        for (int i = 0; i < w.length; i++) {
            w[i] = f(words[i]);
        }
        Arrays.sort(w);
        int[] res = new int[queries.length];
        int j = w.length - 1;
        int total = 0;
        for (int i = 0; i < queries.length; i++) {
            int curr = q[i][0];
            int index = q[i][1];
            while (j >= 0 && w[j] > curr) {
                j--;
                total++;
            }
            res[index] = total;
        }
        return res;
    }

    int f(String s) {
        Arrays.fill(c, 0);
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
        }
        for (int j : c) {
            if (j > 0) {
                return j;
            }
        }
        return 0;
    }
}
