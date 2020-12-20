package com.problems.m;

import java.util.Arrays;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[] index = new int[366];
        Arrays.fill(index, -1);
        for (int i = 0; i < days.length; i++) {
            index[days[i]] = i;
        }
        int[] dp = new int[days.length];
        for (int i = 0; i < days.length; i++) {
            dp[i] = i > 0 ? costs[0] + dp[i - 1] : costs[0];
            int ago = days[i] - 7;
            if (ago < days[0]) {
                dp[i] = Math.min(dp[i], costs[1]);
            } else {
                for (int d = ago; ; d--) {
                    if (index[d] != -1) {
                        dp[i] = Math.min(dp[index[d]] + costs[1], dp[i]);
                        break;
                    }
                }
            }

            ago = days[i] - 30;
            if (ago < days[0]) {
                dp[i] = Math.min(dp[i], costs[2]);
            } else {
                for (int d = ago; ; d--) {
                    if (index[d] != -1) {
                        dp[i] = Math.min(dp[index[d]] + costs[2], dp[i]);
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
