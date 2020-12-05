package com.problems.b;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        res.add(root.val);
        TreeNode curr = null;
        while(!stack.isEmpty()){
            curr = stack.peek();
            while(curr.left!=null){
                stack.push(curr.left);
                res.add(curr.left.val);
                curr.left = null;
                curr = stack.peek();
            }
            curr = stack.pop();
            if(curr.right!=null){
                res.add(curr.right.val);
                stack.push(curr.right);
            }
        }
        return res;
    }
}
