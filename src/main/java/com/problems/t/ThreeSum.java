package com.problems.t;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-01-22.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!result.isEmpty() && result.get(result.size() - 1).get(0) == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (!result.isEmpty() && result.get(result.size() - 1).get(1) == nums[j]
                        && result.get(result.size() - 1).get(0) == nums[i]) {
                    continue;
                }
                int target = -(nums[i] + nums[j]);
                if (target >= 0 && j + 1 < nums.length) {
                    int index = Arrays.binarySearch(nums, j + 1, nums.length, target);
                    if (index >= j + 1) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[index]));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
