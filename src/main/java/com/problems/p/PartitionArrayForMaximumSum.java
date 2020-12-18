package com.problems.p;

public class PartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] arr, int K) {
        long[] dp = new long[arr.length + 1];
        dp[1] = arr[0];
        for (int i = 2; i < dp.length; i++) {
            long max = arr[i - 1];
            for (int k = 1; k <= K && i - k + 1 > 0; k++) {
                int j = i - k + 1;
                max = Math.max(max, arr[j - 1]);
                dp[i] = Math.max(max * k + dp[j - 1], dp[i]);
            }
        }
        return (int) dp[dp.length - 1];
    }
}
