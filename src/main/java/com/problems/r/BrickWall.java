package com.problems.r;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(List<Integer> list: wall){
            sum = 0;
            for(int i=0;i<list.size();i++){
                map.merge(sum + list.get(i), 1, Integer::sum);
                sum += list.get(i);
            }
        }
        int max = 0;
        for(Integer key: map.keySet()){
            if(key != sum){
                max = Math.max(map.get(key), max);
            }
        }
        return wall.size() - max;
    }
}
