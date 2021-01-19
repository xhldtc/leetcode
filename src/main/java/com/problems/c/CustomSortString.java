package com.problems.c;

import java.util.*;

public class CustomSortString {

    public String customSortString(String S, String T) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        List<Character> list = new ArrayList<>(T.length());
        for (char ch : T.toCharArray()) {
            list.add(ch);
        }
        list.sort((c1, c2) -> {
            if (c1.charValue() == c2.charValue()) {
                return 0;
            } else if (map.containsKey(c1) && map.containsKey(c2)) {
                return Integer.compare(map.get(c1), map.get(c2));
            } else if (map.containsKey(c1)) {
                return -1;
            } else if (map.containsKey(c2)) {
                return 1;
            } else {
                return Character.compare(c1, c2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Character c : list)
            sb.append(c);
        return sb.toString();
    }
}
