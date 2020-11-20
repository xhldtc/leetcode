package com.problems.l;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    int[] count = new int[26];

    public int longestSubstring(String s, int k) {
        if (k <= 1)
            return s.length();
        else if (k > s.length())
            return 0;
        int distinct = countChar(s, count);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= k)
                set.add((char) (i + 'a'));
        }
        if (set.isEmpty())
            return 0;
        else if (set.size() == distinct)
            return s.length();
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (sb.length() > 0) {
                res = Math.max(res, longestSubstring(sb.toString(), k));
                sb.delete(0, sb.length());
            }
        }
        if (sb.length() > 0) {
            res = Math.max(res, longestSubstring(sb.toString(), k));
        }
        return res;
    }

    int countChar(String s, int[] count) {
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        int sum = 0;
        for (int c : count) {
            if (c > 0)
                sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("ababbc", 2));
    }
}
