package com.problems.w;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhldtc on 11/12/2018.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        char[] array = pattern.toCharArray();
        Map<Character, String> chToStr = new HashMap<>();
        Map<String, Character> strToCh = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (chToStr.containsKey(array[i])) {
                if (!words[i].equals(chToStr.get(array[i]))) {
                    return false;
                }
            } else if (strToCh.containsKey(words[i])) {
                if (array[i] != strToCh.get(words[i])) {
                    return false;
                }
            } else {
                chToStr.put(array[i], words[i]);
                strToCh.put(words[i], array[i]);
            }
        }
        return true;
    }
}
