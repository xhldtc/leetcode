package com.problems.n;

/**
 * @author xhldtc on 2019-02-12.
 * 字典序算法，思路：
 * 1.从后往前，找出第一个破坏升序的数
 * 2.如果没有，那当前数就是最大的排列数，直接反转变成最小
 * 3.如果找到了，那么在最后一段升序的序列中，从后往前找出第一个大于第1步确定下来的数
 * 4.交往它们的位置，然后将最后一段反转
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int index = nums.length - 2;
        while (index >= 0) {
            if (nums[index] < nums[index + 1]) {
                break;
            }
            index--;
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, index + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,4};
        new NextPermutation().nextPermutation(nums);
        System.out.println(nums);
    }
}
