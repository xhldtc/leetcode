package com.problems.w;

public class WaysToSplitArrayIntoThreeSubarrays {

    public int waysToSplit(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int total = sum[nums.length];
        int j = 2, res = 0, index = -1;
        for (int i = 1; i < nums.length && sum[i] <= total / 3; i++) {
            int first = sum[i];
            while (j < nums.length && sum[j] - first < first) {
                j++;
            }
            if (index == -1) {
                index = j;
                while (index < nums.length && total - sum[index] >= sum[index] - first) {
                    index++;
                }
                res += index - j;
                index--;
            } else {
                while (index >= j && total - sum[index] < sum[index] - first) {
                    index--;
                }
                res += index - j + 1;
            }
            res %= 1000000007;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new WaysToSplitArrayIntoThreeSubarrays().waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
    }
}
