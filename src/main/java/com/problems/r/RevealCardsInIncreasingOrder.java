package com.problems.r;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] a) {
        Arrays.sort(a);
        Deque<Integer> q = new LinkedList<>();
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            q.offer(i);
        }
        int i = 0;
        while (!q.isEmpty()) {
            res[q.poll()] = a[i++];
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }
        return res;
    }
}
