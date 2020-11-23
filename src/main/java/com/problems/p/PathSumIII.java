package com.problems.p;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[1];
        dfs(root, list, sum, res);
        return res[0];
    }

    void dfs(TreeNode node, List<Integer> list, int sum, int[] res) {
        if (node == null)
            return;
        list.add(0);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + node.val);
            if (list.get(i) == sum)
                res[0]++;
        }
        dfs(node.left, list, sum, res);
        dfs(node.right, list, sum, res);
        for (int i = 0; i < list.size() - 1; i++)
            list.set(i, list.get(i) - list.get(list.size() - 1));
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(new PathSumIII().pathSum(root, 8));
    }
}
