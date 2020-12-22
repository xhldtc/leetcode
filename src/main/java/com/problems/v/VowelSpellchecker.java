package com.problems.v;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VowelSpellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String,List<String>> map = new HashMap<>();
        Map<String, List<String>> starMap = new HashMap<>();
        for(String s: wordlist){
            String lower = s.toLowerCase();
            if(!map.containsKey(lower)){
                map.put(lower, new ArrayList<>());
            }
            map.get(lower).add(s);
            String star = toStar(s);
            if(!starMap.containsKey(star)){
                starMap.put(star, new ArrayList<>());
            }
            starMap.get(star).add(s);
        }
        for(int i=0;i<queries.length;i++){
            String query = queries[i];
            String lower = query.toLowerCase();
            String star = toStar(query);
            if(map.containsKey(lower)) {
                List<String> list = map.get(lower);
                if(!list.contains(query)){
                    queries[i] = list.get(0);
                }
            } else if(starMap.containsKey(star)){
                queries[i] = starMap.get(star).get(0);
            } else {
                queries[i] = "";
            }
        }
        return queries;
    }

    String toStar(String s){
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'|| ch == 'u'){
                sb.append('*');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
