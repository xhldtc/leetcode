package com.problems.p;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        if (s.isEmpty())
            return Collections.emptyList();
        List<List<String>> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        dfs(s, stack, res);
        return res;
    }

    void dfs(String s, Stack<String> stack, List<List<String>> res) {
        if (s.isEmpty()) {
            List<String> list = new ArrayList<>(stack);
            res.add(list);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String curr = s.substring(0, i);
            if (isPalindrome(curr)) {
                stack.push(curr);
                dfs(s.substring(i), stack, res);
                stack.pop();
            }
        }
    }

    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }
}
