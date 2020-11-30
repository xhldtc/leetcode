package com.problems.r;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String t = s.substring(i, i + 10);
            if (set.contains(t)) {
                res.add(t);
            } else {
                set.add(t);
            }
        }
        return new ArrayList(res);
    }
}
