package com.problems.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), res);
        return res;
    }

    void dfs(int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        int start = list.isEmpty() ? 1 : list.get(list.size() - 1) + 1;
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, list, res);
            list.remove(list.size() - 1);
        }
    }
}
