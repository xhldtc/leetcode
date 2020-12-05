package com.problems.b;

import com.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr = null;
        while(!stack.isEmpty()){
            curr = stack.pop();
            if(curr.left !=null){
                stack.push(curr.left);
            }
            if(curr.right !=null){
                stack.push(curr.right);
            }
            res.add(curr.val);
        }
        Collections.reverse(res);
        return res;
    }
}
