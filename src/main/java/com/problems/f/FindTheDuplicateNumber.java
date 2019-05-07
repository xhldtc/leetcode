package com.problems.f;

/**
 * @author xhldtc on 2019-05-07.
 */
public class FindTheDuplicateNumber {

    /**
     * 环形链表变种，思路非常巧妙，solutions里有详细介绍
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int start = nums[0];
        while (start != slow) {
            start = nums[start];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(new int[]{4,6,5,1,3,2,5,7}));
    }
}
