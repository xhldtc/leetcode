package com.problems.a;

import com.structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode tmp = new TreeNode(v);
            tmp.left = root;
            return tmp;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty() && depth < d - 1) {
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        int size = q.size();
        for(int i=0;i<size;i++){
            TreeNode node = q.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = new TreeNode(v);
            node.left.left = left;
            node.right = new TreeNode(v);
            node.right.right = right;
        }
        return root;
    }
}
