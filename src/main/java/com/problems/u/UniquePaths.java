package com.problems.u;

import java.util.Arrays;

/**
 * @author xhldtc on 2019-02-26.
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m < n) {
            return uniquePaths(n, m);
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }
        }
        return count[count.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3,7));
    }
}
