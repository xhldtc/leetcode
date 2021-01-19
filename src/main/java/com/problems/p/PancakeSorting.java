package com.problems.p;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != i + 1) {
                int index = find(arr, i - 1, i + 1);
                reverse(arr, index + 1);
                res.add(index + 1);
                reverse(arr, i + 1);
                res.add(i + 1);
            }
        }
        return res;
    }

    int find(int[] arr, int end, int num) {
        for (int i = end; i >= 0; i--) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }

    void reverse(int[] arr, int k) {
        int l = 0, r = k - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}
