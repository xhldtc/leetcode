package com.util;

import com.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeUtils {

    static final String nil = "null";

    public static TreeNode buildBinaryTree(String s) {
        int start = 0, end = s.length() - 1;
        if (s.charAt(start) == '[') {
            start++;
        }
        if (s.charAt(end) == ']') {
            end--;
        }
        s = s.substring(start, end + 1);
        String[] nodes = s.split(",");
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        for (int i = 0; i < nodes.length; i++) {
            String node = nodes[i];
            if (queue.isEmpty()) {
                root = parseTreeNode(node);
                queue.offer(root);
            } else {
                TreeNode curr = queue.poll();
                curr.left = parseTreeNode(node);

                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (i + 1 < nodes.length) {
                    curr.right = parseTreeNode(nodes[++i]);
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }
                }
            }
        }
        return root;
    }

    private static TreeNode parseTreeNode(String s) {
        return nil.equals(s) ? null : new TreeNode(Integer.parseInt(s));
    }

    public static void main(String[] args) {
        TreeUtils.buildBinaryTree("[1,1,1,null,1,null,null,1,1,null,1]");
    }
}
