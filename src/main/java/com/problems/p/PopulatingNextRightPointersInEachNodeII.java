package com.problems.p;

import com.structure.Node;

import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        LinkedList<Node> list = new LinkedList();
        root.val = (root.val + 100) | (1<<8);
        list.add(root);
        Node prev = null;
        int prevDepth = 0;
        while(!list.isEmpty()){
            Node curr = list.removeFirst();
            int depth = curr.val >> 8;
            curr.val = (curr.val & 0xFF) - 100;
            if(prev!=null && depth == prevDepth){
                prev.next = curr;
            }
            if(curr.left != null){
                curr.left.val = (curr.left.val + 100) | ((depth+1)<<8);
                list.add(curr.left);
            }
            if(curr.right != null){
                curr.right.val = (curr.right.val + 100) | ((depth+1)<<8);
                list.add(curr.right);
            }
            prev = curr;
            prevDepth = depth;
        }
        return root;
    }
}
