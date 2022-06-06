package com.problems.s;

import java.util.HashSet;
import java.util.Set;

public class SimilarStringGroups {

    public int numSimilarGroups(String[] strs) {
        int[] fa = new int[strs.length];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (similar(strs[i], strs[j])) {
                    union(i, j, fa);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fa.length; i++) {
            set.add(find(i, fa));
        }
        return set.size();
    }

    boolean similar(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        int first = -1;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if (x != y && first == -1) {
                first = i;
            } else if (x != y) {
                return x == t.charAt(first) && y == s.charAt(first) && s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return false;
    }

    int find(int x, int[] fa) {
        if (x == fa[x]) {
            return x;
        }
        fa[x] = find(fa[x], fa);
        return fa[x];
    }

    void union(int x, int y, int[] fa) {
        x = find(x, fa);
        y = find(y, fa);
        if (x == y) {
            return;
        }
        fa[x] = y;
    }
}
