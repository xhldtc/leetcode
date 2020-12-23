package com.problems.c;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringsThatDifferByOneCharacter {

    public int countSubstrings(String s, String t) {
        Map<String, Map<String, Integer>> smap = build(s);
        Map<String, Map<String, Integer>> tmap = build(t);
        int res = 0;
        for(String starKey: smap.keySet()){
            Map<String, Integer> map1 = smap.get(starKey);
            Map<String, Integer> map2 = tmap.get(starKey);
            if(map2==null){
                continue;
            }
            int map2count = 0;
            for(Integer c: map2.values()){
                map2count += c;
            }
            for(String key: map1.keySet()){
                int val1 = map1.get(key);
                int val2 = map2count - map2.getOrDefault(key, 0);
                res += val1 * val2;
            }
        }
        return res;
    }

    Map<String, Map<String, Integer>> build(String s) {
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                String sub = s.substring(i, j);
                for(int k=0;k<sub.length();k++){
                    String star = sub.substring(0, k) + '*' + sub.substring(k+1);
                    if(!map.containsKey(star)){
                        map.put(star, new HashMap<>());
                    }
                    map.get(star).merge(sub, 1, Integer::sum);
                }
            }
        }
        return map;
    }
}
