package com.problems.b;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xhldtc on 25/11/2018.
 */
public class BinaryTreePaths {

    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        help("", root);
        return list;
    }

    public void help(String prefix, TreeNode node) {
        prefix = prefix.isEmpty() ? String.valueOf(node.val) : prefix + "->" + node.val;
        if (node.left == null && node.right == null) {
            list.add(prefix);
            return;
        }
        if (node.left != null) {
            help(prefix, node.left);
        }
        if (node.right != null) {
            help(prefix, node.right);
        }
    }
}
