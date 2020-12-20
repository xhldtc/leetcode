package com.problems.w;

public class WaysToMakeAFairArray {

    public int waysToMakeFair(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int[] sumJ = new int[nums.length + 1];
        int totalJ = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if (i % 2 == 0) {
                sumJ[i] = sumJ[i - 2] + nums[i - 1];
                totalJ = sumJ[i];
            }
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (i % 2 == 1) {
                int leftSumJ = sumJ[i - 1];
                int leftSumO = sum[i] - sumJ[i - 1];
                int rightSumO = totalJ - leftSumJ - nums[i];
                int rightSumJ = sum[nums.length] - sum[i + 1] - rightSumO;
                if (leftSumJ + rightSumJ == leftSumO + rightSumO) {
                    res++;
                }
            } else {
                int leftSumJ = sumJ[i];
                int leftSumO = sum[i] - sumJ[i];
                int rightSumO = totalJ - leftSumJ;
                int rightSumJ = sum[nums.length] - sum[i + 1] - rightSumO;
                if (leftSumJ + rightSumJ == leftSumO + rightSumO) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new WaysToMakeAFairArray().waysToMakeFair(new int[]{2, 1, 6, 4});
    }
}
