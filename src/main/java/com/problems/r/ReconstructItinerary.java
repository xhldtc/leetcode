package com.problems.r;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((t1, t2) -> {
            if (t1.get(0).equals("JFK") && t2.get(0).equals("JFK")) {
                return t1.get(1).compareTo(t2.get(1));
            } else if (t1.get(0).equals("JFK")) {
                return 1;
            } else if (t2.get(0).equals("JFK")) {
                return -1;
            } else if (!t1.get(0).equals(t2.get(0))) {
                return t1.get(0).compareTo(t2.get(0));
            } else {
                return t1.get(1).compareTo(t2.get(1));
            }
        });
        List<String> res = new ArrayList<>();
        dfs(tickets, new Stack<>(), new boolean[tickets.size()], new boolean[1], res);
        return res;
    }

    void dfs(List<List<String>> tickets, Stack<Integer> stack, boolean[] flag, boolean[] finish,
             List<String> res) {
        if (finish[0]) {
            return;
        } else if (stack.size() == tickets.size()) {
            for (int i : stack) {
                res.add(tickets.get(i).get(0));
            }
            res.add(tickets.get(stack.peek()).get(1));
            finish[0] = true;
            return;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!flag[i]) {
                List<String> ticket = tickets.get(i);
                String prev = stack.isEmpty() ? "JFK" : tickets.get(stack.peek()).get(1);
                if (prev.equals(ticket.get(0))) {
                    flag[i] = true;
                    stack.push(i);
                    dfs(tickets, stack, flag, finish, res);
                    stack.pop();
                    flag[i] = false;
                }
            }
        }
    }
}
