package com.problems.r;

public class RabbitsInForest {

    public int numRabbits(int[] answers) {
        int[] map = new int[1000];
        for (int a : answers) {
            map[a]++;
        }
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                int total = map[i];
                int group = i + 1;
                if (total % group == 0) {
                    res += total;
                } else {
                    res += (total / group) * group + group;
                }
            }
        }
        return res;
    }
}
