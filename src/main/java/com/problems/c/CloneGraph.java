package com.problems.c;

import com.structure.graph.Node;

import java.util.LinkedList;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node[] arr = new Node[101];
        boolean[] flag = new boolean[101];
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            int val = curr.val;
            if (flag[val]) {
                continue;
            }
            if (arr[val] == null) {
                arr[val] = new Node(val);
            }
            for (Node n : curr.neighbors) {
                if (arr[n.val] == null) {
                    arr[n.val] = new Node(n.val);
                }
                arr[val].neighbors.add(arr[n.val]);
                queue.add(n);
            }
            flag[val] = true;
        }
        return arr[node.val];
    }
}
