package com.problems.m;

import java.util.ArrayList;
import java.util.List;

public class MinimumAdjacentSwapsForKConsecutiveOnes {

    public int minMoves(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pos.add(i);
            }
        }
        int[] a = new int[pos.size()];
        for (int i = 0; i < pos.size(); i++) {
            a[i] = pos.get(i) - i;
        }
        int[] sum = new int[a.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + a[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= a.length - k; i++) {
            int mid = i + k / 2;
            int left = (k / 2) * a[mid] - sum[mid] + sum[i];
            int right = sum[i + k] - sum[mid] - (k - k / 2) * a[mid];
            res = Math.min(res, left + right);
        }
        return res;
    }
}
