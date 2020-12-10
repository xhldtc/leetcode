package com.problems.r;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        List<List<String>> dict = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            dict.add(new ArrayList<>());
        }
        for (String s : dictionary) {
            dict.get(s.charAt(0) - 'a').add(s);
        }
        for (List<String> list : dict) {
            list.sort(Comparator.comparingInt(String::length));
        }
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            List<String> list = dict.get(word.charAt(0) - 'a');
            sb.append(' ');
            boolean find = false;
            for (String s : list) {
                if (word.startsWith(s)) {
                    sb.append(s);
                    find = true;
                    break;
                }
            }
            if (!find) {
                sb.append(word);
            }
        }
        return sb.substring(1);
    }
}
