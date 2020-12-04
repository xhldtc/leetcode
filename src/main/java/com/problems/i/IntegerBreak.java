package com.problems.i;

public class IntegerBreak {

    public int integerBreak(int n) {
        int[] record = new int[n + 1];
        record[1] = 1;
        return solve(n, record);
    }

    int solve(int n, int[] record) {
        if (record[n] != 0) {
            return record[n];
        }
        int res = 0;
        for (int i = 1; i <= n / 2; i++) {
            int a = Math.max(i, solve(i, record));
            int b = Math.max(n - i, solve(n - i, record));
            res = Math.max(a * b, res);
        }
        return record[n] = res;
    }
}
