package com.problems.s;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < k - 1; i++) {
            offer(q, nums[i], i);
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            offer(q, nums[i + k - 1], i + k - 1);
            while (q.getFirst()[1] < i) {
                q.removeFirst();
            }
            res[index++] = q.getFirst()[0];
        }
        return res;
    }

    void offer(Deque<int[]> q, int num, int index) {
        while (!q.isEmpty() && num >= q.getLast()[0]) {
            q.removeLast();
        }
        q.offer(new int[]{num, index});
    }
}
