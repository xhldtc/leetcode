package com.problems.b;

public class BeautifulArray {

    public int[] beautifulArray(int N) {
        if (N == 1) {
            return new int[]{1};
        } else if (N == 2) {
            return new int[]{1, 2};
        }
        int[] res = new int[N];
        if (N % 2 == 0) {
            int[] base = beautifulArray(N / 2);
            for (int i = 0; i < N / 2; i++) {
                res[i] = base[i] * 2 - 1;
                res[i + N / 2] = base[i] * 2;
            }
        } else {
            int n = (N + 1) / 2;
            int[] left = beautifulArray(n);
            int[] right = beautifulArray(n - 1);
            for (int i = 0; i < n; i++) {
                res[i] = left[i] * 2 - 1;
            }
            for (int i = 0; i < n - 1; i++) {
                res[i + n] = right[i] * 2;
            }
        }
        return res;
    }
}
