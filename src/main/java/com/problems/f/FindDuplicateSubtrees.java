package com.problems.f;

import com.structure.TreeNode;

import java.util.*;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, List<TreeNode>> map =new HashMap<>();
        Map<Integer, Set<Integer>> index= new HashMap<>();
        dfs(root, map, index);
        List<TreeNode> res = new ArrayList<>();
        for(Integer key: index.keySet()){
            List<TreeNode> list = map.get(key);
            Set<Integer> set = index.get(key);
            for(Integer x: set){
                res.add(list.get(x));
            }
        }
        return res;
    }

    int dfs(TreeNode node, Map<Integer, List<TreeNode>> map, Map<Integer, Set<Integer>> index) {
        if(node == null) {
            return 0;
        }
        int left = dfs(node.left, map, index);
        int right = dfs(node.right, map, index);
        int key = Math.max(left, right) + 1;

        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        List<TreeNode> list = map.get(key);
        boolean find = false;
        for(int i=0;i<list.size();i++) {
            TreeNode tmp = list.get(i);
            if(same(tmp, node)){
                if(!index.containsKey(key)){
                    index.put(key, new HashSet<>());
                }
                index.get(key).add(i);
                find = true;
                break;
            }
        }
        if(!find) {
            list.add(node);
        }
        return key;
    }

    boolean same(TreeNode x, TreeNode y) {
        if(x == null && y == null) {
            return true;
        } else if(x != null && y != null) {
            return x.val == y.val && same(x.left, y.left) && same(x.right, y.right);
        } else {
            return false;
        }
    }
}
