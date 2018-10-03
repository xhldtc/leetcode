package com.problems;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    private void traversal(TreeNode node, int depth, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        if (list.size() < depth) {
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(node.val);
        traversal(node.left, depth + 1, list);
        traversal(node.right, depth + 1, list);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        traversal(root, 1, list);
        Collections.reverse(list);
        return list;
    }
}
