package com.problems.m;

public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] c, int k) {
        int len = c.length;
        int[] sum = new int[len + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + c[i - 1];
        }
        int res = 0;
        for (int i = len - k; i <= len; i++) {
            int leftSum = sum[len] - sum[i];
            int rightSum = sum[k - len + i ];
            res = Math.max(res, leftSum + rightSum);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
}
