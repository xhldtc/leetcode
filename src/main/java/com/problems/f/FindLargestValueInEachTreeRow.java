package com.problems.f;

import com.structure.TreeNode;

import java.util.*;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            int max = q.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
