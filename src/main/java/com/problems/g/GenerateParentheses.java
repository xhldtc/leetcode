package com.problems.g;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xhldtc on 2019-01-31.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<Set<String>> list = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            list.add(new HashSet<>());
        }
        dfs(list, n);
        return new ArrayList<>(list.get(n));
    }

    private void dfs(List<Set<String>> list, int n) {
        if (n == 1) {
            list.get(1).add("()");
        } else {
            if (list.get(n - 1).isEmpty()) {
                dfs(list, n - 1);
            }
            for (int i = 1; i <= n / 2; i++) {
                if (i == 1) {
                    for (String str : list.get(n - 1)) {
                        list.get(n).add("()" + str);
                        list.get(n).add(str + "()");
                        list.get(n).add("(" + str + ")");
                    }
                } else {
                    for (String first : list.get(i)) {
                        for (String second : list.get(n - i)) {
                            list.get(n).add(first + second);
                            list.get(n).add(second + first);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(4));
    }
}
