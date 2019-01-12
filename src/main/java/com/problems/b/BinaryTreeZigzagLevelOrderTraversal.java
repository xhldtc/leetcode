package com.problems.b;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xhldtc on 2019-01-12.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean reverse = false;
        while (!list.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> ints = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                TreeNode curr = list.get(i);
                ints.add(curr.val);
                if (curr.left != null) {
                    next.add(curr.left);
                }
                if (curr.right != null) {
                    next.add(curr.right);
                }
            }
            if (reverse) {
                Collections.reverse(ints);
            }
            reverse = !reverse;
            list = next;
            result.add(ints);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root));
    }
}
