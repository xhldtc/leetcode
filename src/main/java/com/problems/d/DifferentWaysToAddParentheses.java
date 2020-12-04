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
        if (isDigit(input)) {
            return Collections.singletonList(Integer.parseInt(input));
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (ch == '+')
                            res.add(a + b);
                        else if (ch == '-')
                            res.add(a - b);
                        else
                            res.add(a * b);
                    }
                }
            }
        }
        return res;
    }

    boolean isDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
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
