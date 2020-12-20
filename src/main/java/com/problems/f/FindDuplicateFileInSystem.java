package com.problems.f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path: paths){
            String[] arr = path.split("\\s+");
            String dir = arr[0];
            for(int i=1;i<arr.length;i++){
                String s = arr[i];
                int start = s.indexOf('(');
                int end = s.indexOf(')');
                String name = s.substring(0, start);
                String content = s.substring(start+1, end);
                String file = dir + '/' + name;
                if(map.containsKey(content)){
                    map.get(content).add(file);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(file);
                    map.put(content, list);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String content: map.keySet()){
            if(map.get(content).size()>1){
                res.add(map.get(content));
            }
        }
        return res;
    }
}
