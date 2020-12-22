package com.problems.i;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImplementMagicDictionary {

    Map<Integer, List<String>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public ImplementMagicDictionary() {
        
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            int size = word.length();
            if (!map.containsKey(size)) {
                map.put(size, new ArrayList<>());
            }
            map.get(size).add(word);
        }
    }

    public boolean search(String searchWord) {
        List<String> list = map.get(searchWord.length());
        if (list == null) {
            return false;
        }
        for (String s : list) {
            if (match(s, searchWord)) {
                return true;
            }
        }
        return false;
    }

    boolean match(String src, String dst) {
        boolean diff = false;
        for (int i = 0; i < src.length(); i++) {
            char ch1 = src.charAt(i);
            char ch2 = dst.charAt(i);
            if (ch1 != ch2) {
                if (!diff) {
                    diff = true;
                } else {
                    return false;
                }
            }
        }
        return diff;
    }
}
