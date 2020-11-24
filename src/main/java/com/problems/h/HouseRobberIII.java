package com.problems.h;

import com.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> trueMap = new HashMap<>(), falseMap = new HashMap<>();
        return Math.max(solve(root, true, trueMap, falseMap), solve(root, false, trueMap, falseMap));
    }

    int solve(TreeNode node, boolean hasThis, Map<TreeNode, Integer> trueMap, Map<TreeNode, Integer> falseMap) {
        if (node == null)
            return 0;
        else if (hasThis && trueMap.containsKey(node))
            return trueMap.get(node);
        else if (!hasThis && falseMap.containsKey(node))
            return falseMap.get(node);
        else if (hasThis) {
            int val = node.val + solve(node.left, false, trueMap, falseMap) + solve(node.right, false, trueMap, falseMap);
            trueMap.put(node, val);
            return val;
        } else {
            int val = Math.max(solve(node.left, false, trueMap, falseMap), solve(node.left, true, trueMap, falseMap)) +
                    Math.max(solve(node.right, false, trueMap, falseMap), solve(node.right, true, trueMap, falseMap));
            falseMap.put(node, val);
            return val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(new HouseRobberIII().rob(root));
    }
}
