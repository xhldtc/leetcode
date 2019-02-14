package com.problems.p;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-02-14.
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(nums, new boolean[nums.length], 0, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int[] nums, boolean[] visit, int depth, LinkedList<Integer> curr, List<List<Integer>> result) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                curr.addLast(nums[i]);
                dfs(nums, visit, depth + 1, curr, result);
                curr.removeLast();
                visit[i] = false;
            }
        }
    }
}
