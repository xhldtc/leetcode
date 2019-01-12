package com.problems.l;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-01-12.
 */
public class LowestCommonAncestorOfABinaryTree {

    private boolean find = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        find(root, p, new LinkedList<>(), l1);
        find = false;
        List<TreeNode> l2 = new ArrayList<>();
        find(root, q, new LinkedList<>(), l2);
        TreeNode result = null;
        for (int i = 0; i < l1.size() && i < l2.size(); i++) {
            if (l1.get(i) != l2.get(i)) {
                break;
            } else {
                result = l1.get(i);
            }
        }
        return result;
    }

    private void find(TreeNode root, TreeNode node, LinkedList<TreeNode> path, List<TreeNode> result) {
        if (find || root == null || node == null) {
            return;
        }
        if (root.val == node.val) {
            path.add(root);
            find = true;
            result.addAll(path);
            return;
        }
        path.add(root);
        find(root.left, node, path, result);
        path.removeLast();
        path.add(root);
        find(root.right, node, path, result);
        path.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode result = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(root, root.left.right, root.left.right.left);
        System.out.println(result);
    }
}
