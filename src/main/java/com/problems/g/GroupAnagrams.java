package com.problems.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xhldtc on 2019-02-25.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sort = sort(s);
            if (map.containsKey(sort)) {
                map.get(sort).add(s);
            } else {
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(sort, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
