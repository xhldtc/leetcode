package com.problems.c;


public class CreateMaximumNumber {

    private int[] stack;

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        stack = new int[Math.max(nums1.length, nums2.length)];
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int start = k - Math.min(nums2.length, k);
        int end = Math.min(nums1.length, k);
        int[] res = null;
        for (int len = start; len <= end; len++) {
            int[] curr = merge(maxSubArray(nums1, len), maxSubArray(nums2, k - len));
            if (res == null || compare(curr, res, 0, 0) > 0) {
                res = curr;
            }
        }
        return res;
    }

    int compare(int[] a, int[] b, int i, int j) {
        while (i < a.length || j < b.length) {
            if (i < a.length && j < b.length) {
                if (a[i] == b[j]) {
                    i++;
                    j++;
                } else {
                    return Integer.compare(a[i], b[j]);
                }
            } else {
                return i < a.length ? 1 : -1;
            }
        }
        return 0;
    }

    int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, index = 0;
        while (i < a.length || j < b.length) {
            if (i < a.length && j < b.length) {
                res[index++] = compare(a, b, i, j) > 0 ? a[i++] : b[j++];
            } else {
                res[index++] = i < a.length ? a[i++] : b[j++];
            }
        }
        return res;
    }

    int[] maxSubArray(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int size = 0;
        int maxDrop = nums.length - k;
        for (int num : nums) {
            while (size != 0 && stack[size - 1] < num && maxDrop > 0) {
                size--;
                maxDrop--;
            }
            stack[size++] = num;
            if (maxDrop == 0 && size >= k) {
                break;
            }
        }
        int[] res = new int[k];
        System.arraycopy(stack, 0, res, 0, res.length);
        return res;
    }

}
