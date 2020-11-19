package com.problems.g;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] src = new int[gas.length];
        long sum = 0;
        for (int i = 0; i < src.length; i++) {
            src[i] = gas[i] - cost[i];
            sum += src[i];
        }
        if (sum < 0)
            return -1;
        for (int i = 0; i < src.length; i++) {
            if (src[i] < 0)
                continue;
            int index = valid(src, i);
            if (index != i)
                i = index;
            else
                return i;
        }
        return -1;
    }

    private int valid(int[] src, int start) {
        long sum = 0;
        for (int i = start; i < src.length; i++) {
            sum += src[i];
            if (sum < 0)
                return i;
        }
        for (int i = 0; i < start; i++) {
            sum += src[i];
            if (sum < 0)
                return i;
        }
        return start;
    }
}
