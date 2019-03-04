package com.problems.b;

import com.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-03-04.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> list = new LinkedList<>();
        search(root, list, 0);
        return list;
    }

    private void search(TreeNode node, List<List<Integer>> list, int depth) {
        if (node == null) {
            return;
        }
        while (list.size() <= depth) {
            list.add(new LinkedList<>());
        }
        list.get(depth).add(node.val);
        search(node.left, list, depth + 1);
        search(node.right, list, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }
}
