package com.problems.s;

public class StoneGameV {

    public int stoneGameV(int[] stoneValue) {
        int len = stoneValue.length;
        int[][] dp = new int[len][len];
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = stoneValue[i - 1] + sum[i - 1];
        }

        for (int L = 1; L <= len; L++) {
            for (int i = 0; i + L - 1 < len; i++) {
                int j = i + L - 1;
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    int max = 0;
                    for (int s = i; s < j; s++) {
                        int leftSum = sum[s + 1] - sum[i];
                        int rightSum = sum[j + 1] - sum[s + 1];
                        if (leftSum == rightSum) {
                            int tmp = Math.max(rightSum + dp[s + 1][j], leftSum + dp[i][s]);
                            max = Math.max(max, tmp);
                        } else if (leftSum > rightSum) {
                            max = Math.max(max, rightSum + dp[s + 1][j]);
                        } else {
                            max = Math.max(max, leftSum + dp[i][s]);
                        }
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[0][len - 1];
    }
}
