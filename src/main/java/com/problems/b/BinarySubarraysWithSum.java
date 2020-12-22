package com.problems.b;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] A, int S) {
        int[] map = new int[30001];
        map[0] = 1;
        int sum = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum >= S) {
                res += map[sum - S];
            }
            map[sum]++;
        }
        return res;
    }
}
