package com.problems.l;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String max = String.valueOf(nums[0]);
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int[] len = new int[nums.length];
        len[0] = max.length();
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int largestIndex = 0;
            String prevMax = max;
            max = num + max;
            for (int j = 0; j < list.size(); j++) {
                String s = prevMax.substring(0, len[j]) + num + prevMax.substring(len[j]);
                if (s.compareTo(max) > 0) {
                    largestIndex = j + 1;
                    max = s;
                }
            }
            list.add(largestIndex, num);
            update(len, list);
        }
        return removeZero(max);
    }

    String removeZero(String s) {
        for (char ch : s.toCharArray()) {
            if (ch != '0')
                return s;
        }
        return "0";
    }

    void update(int[] len, List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += String.valueOf(list.get(i)).length();
            len[i] = sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().removeZero("00"));
        System.out.println(new LargestNumber().largestNumber(new int[]{10, 2, 9, 39, 17}));
    }
}
