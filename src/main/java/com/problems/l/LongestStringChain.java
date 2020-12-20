package com.problems.l;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>(words.length);
        int[] dp = new int[words.length];
        int res = 1;
        for (int i = 0; i < words.length; i++) {
            int max = 1;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String temp = word.substring(0, j) + word.substring(j + 1);
                if (map.containsKey(temp)) {
                    max = Math.max(max, 1 + map.get(temp));
                }
            }
            map.put(word, max);
            res = Math.max(res, max);
        }
        return res;
    }
}
