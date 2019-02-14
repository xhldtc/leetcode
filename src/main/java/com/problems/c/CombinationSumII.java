package com.problems.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-02-14.
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new LinkedList<>();
        dfs(candidates, 0, target, 0, new LinkedList<>(), list);
        return list;
    }

    private void dfs(int[] candidates, int index, int target, int sum, LinkedList<Integer> curr,
                     List<List<Integer>> result) {
        if (sum >= target) {
            if (sum == target) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            curr.addLast(candidates[i]);
            dfs(candidates, i + 1, target, sum, curr, result);
            curr.removeLast();
            sum -= candidates[i];
        }
    }
}
