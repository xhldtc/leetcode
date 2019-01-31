package com.problems.l;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xhldtc on 2019-01-31.
 */
public class LetterCombinationsOfAPhoneNumber {

    private String[] map = new String[]{null, null, "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        dfs(digits, 0, sb, set);
        return new ArrayList<>(set);
    }

    private void dfs(String digits, int depth, StringBuilder sb, Set<String> set) {
        if (depth >= digits.length()) {
            set.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(depth) - '0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            dfs(digits, depth + 1, sb, set);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
    }
}
