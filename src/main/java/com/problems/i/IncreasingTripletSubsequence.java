package com.problems.i;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < list.get(0)) {
                list.set(0, num);
            } else if (num > list.get(0)) {
                if (list.size() == 1) {
                    list.add(num);
                } else if (num < list.get(1)) {
                    list.set(1, num);
                } else if (num > list.get(1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{9, 7, 20, 4, 5, 8}));
    }
}
