package com.problems.a;

import com.structure.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        dfs(root);
        Deque<Integer> q = new LinkedList<>();
        q.offer(target.val);
        List<Integer> res = new ArrayList<>();
        if (K == 0) {
            res.addAll(q);
            return res;
        }
        Set<Integer> set = new HashSet<>();
        int k = 0;
        while (!q.isEmpty() && k++ < K) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int val = q.poll();
                set.add(val);
                List<Integer> child = map.getOrDefault(val, Collections.emptyList());
                for (Integer num : child) {
                    if (!set.contains(num)) {
                        q.offer(num);
                    }
                }
            }
            if (k == K) {
                res.addAll(q);
                break;
            }
        }
        return res;
    }

    void dfs(TreeNode node) {
        map.computeIfAbsent(node.val, k -> new ArrayList<>());
        if (node.left != null) {
            map.get(node.val).add(node.left.val);
            map.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
            dfs(node.left);
        }
        if (node.right != null) {
            map.get(node.val).add(node.right.val);
            map.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
            dfs(node.right);
        }
    }
}
