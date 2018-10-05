package com.problems.m;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            boolean find = false;
            for (int j = 0; j < m; j++) {
                if (nums1[j] >= nums2[i]) {
                    find = true;
                    for (int k = m; k > j; k--) {
                        nums1[k] = nums1[k - 1];
                    }
                    nums1[j] = nums2[i];
                    break;
                }
            }
            if (!find) {
                nums1[m] = nums2[i];
            }
            m++;
        }
    }
}
