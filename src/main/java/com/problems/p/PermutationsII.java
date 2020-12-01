package com.problems.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, flag, stack, res, 0);
        return res;
    }

    void dfs(int[] nums, boolean[] flag, Stack<Integer> stack, List<List<Integer>> res, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }
        int prev = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(!flag[i] && num != prev){
                flag[i] = true;
                stack.push(num);
                dfs(nums, flag, stack, res, depth+1);
                stack.pop();
                flag[i] = false;
                prev = num;
            }
        }
    }
}
