package com.problems.s;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public List<Integer> splitIntoFibonacci(String num) {
        String max = String.valueOf(Integer.MAX_VALUE);
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= Math.min(10, num.length() / 2); i++) {
            for (int j = 1; j <= 10; j++) {
                int remain = num.length() - i - j;
                if (remain < Math.max(i, j)) {
                    break;
                }
                String s1 = num.substring(0, i);
                String s2 = num.substring(i, i + j);
                if (!valid(s1, max) || !valid(s2, max)) {
                    continue;
                }
                int num1 = Integer.parseInt(s1);
                int num2 = Integer.parseInt(s2);
                res.add(num1);
                res.add(num2);
                res = solve(num1, num2, num.substring(i + j), res);
                if (!res.isEmpty())
                    return res;
            }
        }
        return Collections.emptyList();
    }

    boolean valid(String s, String max) {
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        } else if (s.length() == 10) {
            return s.compareTo(max) <= 0;
        }
        return true;
    }

    List<Integer> solve(int x, int y, String num, List<Integer> list) {
        int sum = x + y;
        if (sum < 0) {
            list.clear();
            return list;
        }
        String res = String.valueOf(sum);
        if (num.equals(res)) {
            list.add(sum);
            return list;
        } else if (num.startsWith(res)) {
            list.add(sum);
            return solve(y, sum, num.substring(res.length()), list);
        } else {
            list.clear();
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SplitArrayIntoFibonacciSequence().splitIntoFibonacci("123456579"));
    }
}
