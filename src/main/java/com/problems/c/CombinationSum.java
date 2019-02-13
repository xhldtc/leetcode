package com.problems.c;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-02-13.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, 0, new LinkedList<>(), result);
        return result;
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
            sum += candidates[i];
            curr.addLast(candidates[i]);
            dfs(candidates, i, target, sum, curr, result);
            curr.removeLast();
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
