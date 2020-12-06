package com.problems.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer count = map.get(ch);
            int c = count == null ? 1 : count + 1;
            map.put(ch, c);
        }
        List<Count> list = new ArrayList<>(map.size());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new Count(entry.getKey(), entry.getValue()));
        }
        list.sort((c1, c2) -> Integer.compare(c2.count, c1.count));
        StringBuilder sb = new StringBuilder();
        for (Count c : list) {
            for (int i = 0; i < c.count; i++) {
                sb.append(c.ch);
            }
        }
        return sb.toString();
    }

    static class Count {
        char ch;
        int count;

        public Count(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
