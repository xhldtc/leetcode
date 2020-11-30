package com.problems.p;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, new Stack<>(), res, 0, sum);
        return res;
    }

    void dfs(TreeNode node, Stack<Integer> stack, List<List<Integer>> res, int currSum, int sum) {
        stack.push(node.val);
        currSum += node.val;
        if (node.left != null) {
            dfs(node.left, stack, res, currSum, sum);
        }
        if (node.right != null) {
            dfs(node.right, stack, res, currSum, sum);
        }
        if (node.left == null && node.right == null && currSum == sum) {
            res.add(new ArrayList(stack));
        }
        stack.pop();
    }
}
