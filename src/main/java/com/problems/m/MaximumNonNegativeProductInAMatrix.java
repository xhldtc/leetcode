package com.problems.m;

public class MaximumNonNegativeProductInAMatrix {

    public int maxProductPath(int[][] grid) {
        Long[][][] dp = new Long[grid.length][grid[0].length][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    set(dp[i][j], grid[0][0]);
                } else if (i == 0) {
                    long num = multi(dp[i][j - 1], grid[i][j]);
                    set(dp[i][j], num);
                } else if (j == 0) {
                    long num = multi(dp[i - 1][j], grid[i][j]);
                    set(dp[i][j], num);
                } else {
                    if (dp[i][j - 1][1] != null || dp[i - 1][j][1] != null || grid[i][j] == 0) {
                        dp[i][j][1] = 0L;
                    }
                    if (grid[i][j] > 0) {
                        Long maxPos = maxPos(dp[i][j - 1], dp[i - 1][j]);
                        if (maxPos != null) {
                            dp[i][j][0] = maxPos * grid[i][j];
                        }
                        Long minNeg = minNeg(dp[i][j - 1], dp[i - 1][j]);
                        if (minNeg != null) {
                            dp[i][j][2] = minNeg * grid[i][j];
                        }
                    }
                    if (grid[i][j] < 0) {
                        Long maxPos = maxPos(dp[i][j - 1], dp[i - 1][j]);
                        if (maxPos != null) {
                            dp[i][j][2] = maxPos * grid[i][j];
                        }
                        Long minNeg = minNeg(dp[i][j - 1], dp[i - 1][j]);
                        if (minNeg != null) {
                            dp[i][j][0] = minNeg * grid[i][j];
                        }
                    }
                }
            }
        }
        Long[] L = dp[grid.length - 1][grid[0].length - 1];
        long mod = 1000000007;
        if (L[0] != null) {
            return (int) (L[0] % mod);
        } else if (L[1] != null) {
            return 0;
        } else {
            return -1;
        }
    }

    Long maxPos(Long[] L1, Long[] L2) {
        if (L1[0] == null && L2[0] == null) {
            return null;
        } else if (L1[0] == null) {
            return L2[0];
        } else if (L2[0] == null) {
            return L1[0];
        } else {
            return Math.max(L1[0], L2[0]);
        }
    }

    Long minNeg(Long[] L1, Long[] L2) {
        if (L1[2] == null && L2[2] == null) {
            return null;
        } else if (L1[2] == null) {
            return L2[2];
        } else if (L2[2] == null) {
            return L1[2];
        } else {
            return Math.min(L1[2], L2[2]);
        }
    }


    long multi(Long[] ints, long num) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != null) {
                return ints[i] * num;
            }
        }
        return 0;
    }

    void set(Long[] ints, long num) {
        if (num > 0) {
            ints[0] = num;
        } else if (num < 0) {
            ints[2] = num;
        } else {
            ints[1] = num;
        }
    }
}
