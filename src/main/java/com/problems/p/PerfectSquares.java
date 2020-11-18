package com.problems.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        List<Integer> squares = squareList();
        for (int num = 1; num <= n; num++) {
            for (int i = 0; i < squares.size() && num >= squares.get(i); i++) {
                int square = squares.get(i);
                int remain = num % square;
                dp[num] = Math.min(dp[num], dp[remain] + num / square);
            }
        }
        return dp[n];
    }

    List<Integer> squareList() {
        List<Integer> list = new ArrayList<>();
        for (long i = 1; i * i <= Integer.MAX_VALUE; i++)
            list.add((int) (i * i));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(13));
    }
}
