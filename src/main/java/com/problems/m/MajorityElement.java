package com.problems.m;

public class MajorityElement {

    /**
     * 这个算法真的巧妙：参考https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     */
    public int majorityElement(int[] nums) {
        int count = 0, major = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
            }
            count += num == major ? 1 : -1;
        }
        return major;
    }
}
