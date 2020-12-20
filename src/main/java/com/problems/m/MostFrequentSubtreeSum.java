package com.problems.m;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + dfs(node.left, map) + dfs(node.right, map);
        Integer count = map.get(sum);
        if (count == null) {
            map.put(sum, 1);
        } else {
            map.put(sum, count + 1);
        }
        return sum;
    }
}
