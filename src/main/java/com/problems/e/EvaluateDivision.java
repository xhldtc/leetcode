package com.problems.e;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> map = new HashMap<>();
        for(int i=0;i<equations.size();i++) {
            List<String> e = equations.get(i);
            map.computeIfAbsent(e.get(0), k -> new ArrayList<>()).add(new Node(e.get(1), values[i]));
            map.computeIfAbsent(e.get(1), k -> new ArrayList<>()).add(new Node(e.get(0), 1d / values[i]));
        }
        double[] res = new double[queries.size()];
        for(int i=0;i<res.length;i++) {
            List<String> q = queries.get(i);
            if(map.containsKey(q.get(0)) && map.containsKey(q.get(1))) {
                res[i] = bfs(map, q);
            } else {
                res[i] = -1d;
            }
        }
        return res;
    }

    double bfs(Map<String, List<Node>> map, List<String> query) {
        if(query.get(0).equals(query.get(1))) {
            return 1d;
        }
        Deque<Node> q = new LinkedList<>();
        q.offer(new Node(query.get(0), 1d));
        Set<String> set = new HashSet<>();
        while(!q.isEmpty()) {
            Node node = q.poll();
            set.add(node.s);
            List<Node> child = map.get(node.s);
            for(Node c : child) {
                if(!set.contains(c.s)) {
                    if(c.s.equals(query.get(1))) {
                        return node.val * c.val;
                    } else {
                        q.offer(new Node(c.s, node.val * c.val));
                    }
                }
            }
        }
        return -1d;
    }

    static class Node {
        String s;
        double val;

        Node(String s, double val) {
            this.s = s;
            this.val = val;
        }
    }
}
