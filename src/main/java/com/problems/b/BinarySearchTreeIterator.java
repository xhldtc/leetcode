package com.problems.b;

import com.structure.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        fill(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        fill(node.right);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    void fill(TreeNode node){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }
}
