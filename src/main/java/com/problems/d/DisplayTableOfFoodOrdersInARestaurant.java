package com.problems.d;

import java.util.*;

public class DisplayTableOfFoodOrdersInARestaurant {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        Set<String> set = new TreeSet<>();
        for(List<String> list : orders) {
            int table = Integer.parseInt(list.get(1));
            String food = list.get(2);
            if(!map.containsKey(table)){
                map.put(table ,new HashMap<>());
            }
            set.add(food);
            map.get(table).merge(food, 1, Integer::sum);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(set);
        res.add(head);
        for(Map.Entry<Integer, Map<String, Integer>> entry: map.entrySet()){
            List<String> curr = new ArrayList<>();
            curr.add(String.valueOf(entry.getKey()));
            Map<String, Integer> mp = entry.getValue();
            for(String s: set){
                curr.add(String.valueOf(mp.getOrDefault(s, 0)));
            }
            res.add(curr);
        }
        return res;
    }
}
