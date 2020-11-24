package com.problems.t;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        int[] count = new int[26];
        for (char c : tasks)
            count[c - 'A']++;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                list.add(count[i]);
        }
        list.sort(Comparator.reverseOrder());
        int res = list.get(0) * (n + 1) - n;
        int[] curr = new int[n + 1], next = new int[n + 1];
        curr[n] = list.get(0) - 1;
        for (int i = 1; i < list.size(); i++) {
            int task = list.get(i);
            for (int j = n; j >= 0; j--) {

            }
        }

        return 0;
    }
}
