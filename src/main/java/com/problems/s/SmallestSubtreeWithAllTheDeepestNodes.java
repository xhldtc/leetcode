package com.problems.s;

import com.structure.TreeNode;
import com.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SmallestSubtreeWithAllTheDeepestNodes {

    List<List<Integer>> paths = new ArrayList<>();
    int max = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, new Stack<>());
        paths = paths.stream().filter(x -> x.size() == max).collect(Collectors.toList());
        if (paths.size() == 1) {
            return search(root, paths.get(0).get(max - 1));
        }
        int i;
        for (i = 0; i < max; i++) {
            int common = paths.get(0).get(i);
            for (int j = 1; j < paths.size(); j++) {
                if (paths.get(j).get(i) != common) {
                    return search(root, paths.get(0).get(i - 1));
                }
            }
        }
        return null;
    }

    TreeNode search(TreeNode node, int num) {
        if (node == null) {
            return null;
        }
        if (node.val == num) {
            return node;
        } else {
            TreeNode res = search(node.left, num);
            if (res != null) {
                return res;
            }
            return search(node.right, num);
        }
    }

    void dfs(TreeNode node, Stack<Integer> path) {
        path.push(node.val);
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
            max = Math.max(max, path.size());
        } else {
            if (node.left != null) {
                dfs(node.left, path);
            }
            if (node.right != null) {
                dfs(node.right, path);
            }
        }
        path.pop();
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildBinaryTree("[3,5,1,6,2,0,8,null,null,7,4]");
        System.out.println(new SmallestSubtreeWithAllTheDeepestNodes().subtreeWithAllDeepest(root));
    }
}
