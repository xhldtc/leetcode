package com.problems.v;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhldtc on 25/11/2018.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {
                map.compute(ch, (k, v) -> v - 1);
                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
}
