package com.problems.b;

import com.structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-03-01.
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.removeFirst();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            curr.left = null;
            curr.right = null;
            if (left == null && right == null) {
                list.add(curr.val);
            } else if (left == null) {
                queue.addFirst(right);
                queue.addFirst(curr);
            } else if (right == null) {
                queue.addFirst(curr);
                queue.addFirst(left);
            } else {
                queue.addFirst(right);
                queue.addFirst(curr);
                queue.addFirst(left);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(root));
    }
}
