package com.problems.m;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingFileNamesUnique {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> main = new HashMap<>();
        Map<String, Set<Integer>> used = new HashMap<>();
        for (String name : names) {
            if(!main.containsKey(name)){
                main.put(name, 1);
                used.put(name, new HashSet<>());
            } else {
                int next = main.get(name);
                String nextName = name +'(' + next +')';
                main.put(nextName, 1);
                used.put(nextName, new HashSet<>());
            }
        }
        return null;
    }

    String prefix(String s) {
        int index = s.lastIndexOf('(');
        return s.substring(0, index);
    }

    int suffix(String s) {
        int start = s.lastIndexOf('(');
        int end = s.lastIndexOf(')');
        if (end == s.length() - 1 && start > 0) {
            String num = s.substring(start + 1, end);
            if (num.length() == 0 || num.charAt(0) == '0') {
                return -1;
            }
            for (char ch : s.toCharArray()) {
                if (ch < '0' || ch > '9') {
                    return -1;
                }
            }
            return Integer.parseInt(num);
        } else {
            return -1;
        }
    }
}
