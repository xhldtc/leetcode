package com.problems.a;

public class ArrayNesting {

    public int arrayNesting(int[] a) {
        boolean[] flag = new boolean[a.length];
        int res = 1;
        for (int i = 0; i < a.length; i++) {
            if (!flag[i]) {
                flag[i] = true;
                int c = 1, index = a[i];
                while (a[index] != a[i]) {
                    flag[index] = true;
                    index = a[index];
                    c++;
                }
                res = Math.max(res, c);
            }
        }
        return res;
    }
}
