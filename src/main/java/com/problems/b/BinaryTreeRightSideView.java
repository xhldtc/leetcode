package com.problems.b;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    void dfs(TreeNode node, int depth, List<Integer> res) {
        if(node == null){
            return;
        }
        while(depth >= res.size()){
            res.add(0);
        }
        res.set(depth, node.val);
        dfs(node.left, depth + 1, res);
        dfs(node.right, depth + 1, res);
    }
}
