package com.problems.i;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhldtc on 24/11/2018.
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        return help(s, t) && help(t, s);
    }

    private boolean help(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
