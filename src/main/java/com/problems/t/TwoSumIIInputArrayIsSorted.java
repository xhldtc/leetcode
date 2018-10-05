package com.problems.t;

public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 1; i < numbers.length; i++) {
            int index = search(numbers, i, numbers.length - 1, target - numbers[i - 1]);
            if (index != -1) {
                return new int[]{i, index + 1};
            }
        }
        return new int[]{-1, -1};
    }

    private int search(int[] numbers, int start, int end, int target) {
        if (start == end) {
            return numbers[start] == target ? start : -1;
        } else {
            int mid = (start + end) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] > target) {
                return search(numbers, start, mid, target);
            } else {
                return search(numbers, mid + 1, end, target);
            }
        }
    }
}
