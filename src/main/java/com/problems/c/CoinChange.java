package com.problems.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        List<Integer> list = new ArrayList<>();
        for (int coin : coins) {
            if (coin < amount)
                list.add(coin);
            else if (coin == amount)
                return 1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : list) {
                if (i >= coin && dp[i - coin] != -1)
                    dp[i] = dp[i] == -1 ? dp[i - coin] + 1 : Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount];
    }
}
