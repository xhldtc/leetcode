package com.problems.b;

public class BeautifulArrangement {

    int res = 0;
    boolean[] flag;

    public int countArrangement(int n) {
        flag = new boolean[n + 1];
        dfs(1, n);
        return res;
    }

    void dfs(int d, int n) {
        if (d > n) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!flag[i] && (i % d == 0 || d % i == 0)) {
                flag[i] = true;
                dfs(d + 1, n);
                flag[i] = false;
            }
        }
    }
}
