package com.problems.l;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhldtc on 2019-01-14.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, curr = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                curr++;
            } else {
                int index = map.get(ch);
                curr = i - index;
                map.entrySet().removeIf(e -> e.getValue() < index);
            }
            map.put(ch, i);
            max = Math.max(curr, max);
        }
        max = Math.max(curr, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }
}
