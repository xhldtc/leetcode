package com.problems.b;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                maxProfit += prices[i - 1] - min;
                min = prices[i];
            }
        }
        if (prices[prices.length - 1] >= prices[prices.length - 2]) {
            maxProfit += prices[prices.length - 1] - min;
        }
        return maxProfit;
    }
}
