package com.problems.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        char c = input.charAt(0);
        if (c == '-' || c == '+') {
            input = "0" + input;
        }

        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int base = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= '0' && ch <= '9') {
                base = base * 10 + ch - '0';
            } else {
                ops.add(ch);
                nums.add(base);
                base = 0;
            }
        }
        nums.add(base);
        return calc(nums, ops);
    }

    List<Integer> calc(List<Integer> nums, List<Character> ops) {
        if (ops.size() == 1) {
            char c = ops.get(0);
            int a = nums.get(0), b = nums.get(1);
            return Collections.singletonList(calc(a, b, c));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < ops.size(); i++) {
            int num = calc(nums.get(i), nums.get(i + 1), ops.get(i));
            List<Integer> nextNums = new ArrayList<>(nums.subList(0, i));
            nextNums.add(num);
            nextNums.addAll(nums.subList(i + 2, nums.size()));
            List<Character> nextOps = new ArrayList<>(ops.subList(0, i));
            nextOps.addAll(ops.subList(i + 1, ops.size()));
            res.addAll(calc(nextNums, nextOps));
        }
        return res;
    }

    int calc(int a, int b, char c) {
        if (c == '+')
            return a + b;
        else if (c == '-')
            return a - b;
        else
            return a * b;
    }

    public static void main(String[] args) {
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5"));
    }
}
