package com.problems.f;

public class FillingBookcaseShelves {

    //令dp[i]为以放完当前书做为分隔，书架的最小高度
    public int minHeightShelves(int[][] b, int sw) {
        int[] dp = new int[b.length];
        dp[0] = b[0][1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + b[i][1];
            int len = b[i][0], height = b[i][1];
            for (int j = i - 1; j >= 0; j--) {
                if (len + b[j][0] > sw) {
                    break;
                }
                len += b[j][0];
                height = Math.max(b[j][1], height);
                int prev = j - 1 >= 0 ? dp[j - 1] : 0;
                dp[i] = Math.min(dp[i], prev + height);
            }
        }
        return dp[dp.length - 1];
    }
}
