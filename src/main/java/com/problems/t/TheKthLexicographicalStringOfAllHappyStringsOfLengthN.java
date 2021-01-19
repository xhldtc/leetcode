package com.problems.t;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    char[] ch;
    PriorityQueue<String> q = new PriorityQueue<>(Comparator.reverseOrder());
    int n, k;

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        ch = new char[n];
        dfs(0);
        return q.size() == k ? q.peek() : "";
    }

    void dfs(int d) {
        if (d == n) {
            String s = new String(ch);
            if (q.size() < k) {
                q.offer(s);
            } else if (s.compareTo(q.peek()) < 0) {
                q.poll();
                q.offer(s);
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            char curr = (char) ('a' + i);
            if (d == 0 || curr != ch[d - 1]) {
                ch[d] = curr;
                dfs(d + 1);
            }
        }
    }
}
