package com.problems.s;

import java.util.ArrayList;
import java.util.List;

public class StoneGameIV {

    //dp[i] true代表先手必胜，false代表先手必败
    public boolean winnerSquareGame(int n) {
        int i = 1;
        List<Integer> squares = new ArrayList<>();
        while (i * i <= n) {
            squares.add(i * i);
            i++;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (i = 1; i <= n; i++) {
            for (int j = 0; j < squares.size() && i >= squares.get(j); j++) {
                if (!dp[i - squares.get(j)]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
