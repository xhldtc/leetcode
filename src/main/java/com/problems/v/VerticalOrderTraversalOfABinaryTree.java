package com.problems.v;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class VerticalOrderTraversalOfABinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> list = new ArrayList<>();
        dfs(root, list, 0, 0);
        list.sort((n1, n2) -> {
            if (n1.x != n2.x) {
                return Integer.compare(n1.x, n2.x);
            } else if (n1.y != n2.y) {
                return Integer.compare(n2.y, n1.y);
            } else {
                return Integer.compare(n1.val, n2.val);
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int prev = Integer.MAX_VALUE;
        for (Node node : list) {
            if (node.x != prev) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(node.val);
                res.add(tmp);
            } else {
                res.get(res.size() - 1).add(node.val);
            }
            prev = node.x;
        }
        return res;
    }

    void dfs(TreeNode node, List<Node> list, int x, int y) {
        if (node == null) {
            return;
        }
        list.add(new Node(x, y, node.val));
        dfs(node.left, list, x - 1, y - 1);
        dfs(node.right, list, x + 1, y - 1);
    }

    static class Node {
        int x, y, val;

        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
