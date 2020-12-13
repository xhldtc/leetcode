package com.problems.s;

public class StoneGameIII {

    public String stoneGameIII(int[] stoneValue) {
        int[][] dp = new int[stoneValue.length][4];
        for (int i = 1; i <= 3; i++) {
            dp[stoneValue.length - 1][i] = stoneValue[stoneValue.length - 1];
        }
        int[] sum = new int[stoneValue.length];
        sum[stoneValue.length - 1] = stoneValue[stoneValue.length - 1];
        for (int i = stoneValue.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + stoneValue[i];
        }

        for (int i = stoneValue.length - 2; i >= 0; i--) {
            dp[i][1] = stoneValue[i] + sum[i + 1] - max(dp[i + 1][1], dp[i + 1][2], dp[i + 1][3]);
            int max2 = (i + 2 < stoneValue.length) ? sum[i + 2] - max(dp[i + 2][1], dp[i + 2][2], dp[i + 2][3]) : 0;
            dp[i][2] = stoneValue[i] + stoneValue[i + 1] + max2;
            int max3 = (i + 3 < stoneValue.length) ? sum[i + 3] - max(dp[i + 3][1], dp[i + 3][2], dp[i + 3][3]) : 0;
            dp[i][3] = stoneValue[i] + stoneValue[i + 1] + ((i + 2 < stoneValue.length) ? stoneValue[i + 2] : 0) + max3;
        }
        int alice = max(dp[0][1], dp[0][2], dp[0][3]);
        int bob = sum[0] - alice;
        if (alice > bob) {
            return "Alice";
        } else if (bob > alice) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    int max(int a, int b, int c) {
        int t = Math.max(a, b);
        return Math.max(t, c);
    }

    public static void main(String[] args) {
        System.out.println(new StoneGameIII().stoneGameIII(new int[]{1, 2, 3, 7}));
    }
}
