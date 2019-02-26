package com.problems.s;

/**
 * @author xhldtc on 2019-02-26.
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = left; i <= right; i++) {
            if (nums[i] == 0 && i > left) {
                swap(nums, i, left);
                left++;
                i--;
            } else if (nums[i] == 2 && i < right) {
                swap(nums, i, right);
                right--;
                i--;
            }
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 0, 1, 2, 1, 0};
        new SortColors().sortColors(nums);
        System.out.println(nums);
    }
}
