package com.problems.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        return solve(k, n, 1);
    }

    List<List<Integer>> solve(int k, int n, int start) {
        if (k == 1 && n >= start) {
            List<Integer> list = new ArrayList<>();
            list.add(n);
            return Collections.singletonList(list);
        }
        int min = (start * 2 + k - 1) * k / 2;
        int max = (19 - k) * k / 2;
        if (n < min || n > max) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = start; i < 10 && n >= i; i++) {
            List<List<Integer>> tmp = solve(k - 1, n - i, i + 1);
            for (List<Integer> list : tmp) {
                list.add(0, i);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIII().combinationSum3(3, 7));
    }
}
