package com.problems.r;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xhldtc on 2019-01-12.
 */
public class RestoreIPAddresses {

    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        dfs(s, new LinkedList<>(), 0);
        return result;
    }

    private void dfs(String s, LinkedList<String> list, int depth) {
        if (s.isEmpty()) {
            return;
        }
        if (depth == 3) {
            if (valid(s)) {
                String sss = list.get(0) + "." + list.get(1) + "." + list.get(2) + "." + s;
                result.add(sss);
            }
            return;
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            String curr = s.substring(0, i);
            if (valid(curr)) {
                list.addLast(curr);
                dfs(s.substring(i), list, depth + 1);
                list.removeLast();
            }
        }
    }

    private boolean valid(String s) {
        if (s.startsWith("0")) {
            return s.equals("0");
        } else {
            int num = Integer.valueOf(s);
            return num >= 0 && num < 256;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("010010"));
    }
}
