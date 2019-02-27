package com.problems.s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xhldtc on 2019-02-27.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >>> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            set.add(list);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
