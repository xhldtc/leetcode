package com.problems.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>(n);
        int len = String.valueOf(n).length();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, 1, len, res);
        }
        return res;
    }

    void dfs(int num, int n, int depth, int len, List<Integer> res) {
        if (num <= n) {
            res.add(num);
            if (depth == len) {
                return;
            }
            for (int i = 0; i < 10; i++) {
                dfs(num * 10 + i, n, depth + 1, len, res);
            }
        }
    }
}
