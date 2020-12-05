package com.problems.t;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        for (char ch : tasks) {
            count[ch - 'A']++;
            max = Math.max(count[ch - 'A'], max);
        }
        int maxCount = 0, sum = 0;
        for (int c : count) {
            sum += c;
            if (c == max) {
                maxCount++;
            }
        }

        if (maxCount >= n + 1) {
            return sum;
        } else {
            int len = (n + 1) * (max - 1) + maxCount;
            int slot = (n + 1 - maxCount) * (max - 1);
            int remain = sum - max * maxCount;
            return slot >= remain ? len : len + remain - slot;
        }
    }
}
