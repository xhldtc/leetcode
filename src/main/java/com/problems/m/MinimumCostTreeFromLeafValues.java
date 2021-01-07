package com.problems.m;

public class MinimumCostTreeFromLeafValues {

    int[][] max;

    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        max = new int[len][len];
        for (int i = 0; i < len; i++) {
            max[i][i] = arr[i];
            for (int j = i + 1; j < len; j++) {
                max[i][j] = Math.max(max[i][j - 1], arr[j]);
            }
        }
        int[][] mem = new int[len][len];
        return dfs(arr, mem, 0, len - 1);
    }

    int dfs(int[] arr, int[][] mem, int start, int end) {
        if (mem[start][end] > 0) {
            return mem[start][end];
        } else if (start == end) {
            return 0;
        } else if (start + 1 == end) {
            mem[start][end] = arr[start] * arr[end];
            return mem[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int sum = dfs(arr, mem, start, i) + dfs(arr, mem, i + 1, end);
            sum += max[start][i] * max[i + 1][end];
            res = Math.min(res, sum);
        }
        mem[start][end] = res;
        return res;
    }
}
