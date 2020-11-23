package com.problems.p;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if ((sum & 1) != 0)
            return false;
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                if (dp[j - nums[i]]) {
                    dp[j] = true;
                    if (j == sum)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 5}));
    }
}
