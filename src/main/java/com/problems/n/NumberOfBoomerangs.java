package com.problems.n;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] p) {
        Map<Integer, Integer>[] maps = new Map[p.length];
        for(int i=0;i<maps.length;i++){
            maps[i] = new HashMap<>();
        }
        for(int i=0;i<p.length;i++){
            for(int j=i+1;j<p.length;j++){
                int x = p[i][0] - p[j][0];
                int y = p[i][1] - p[j][1];
                int dis = x * x + y * y;
                maps[i].merge(dis, 1, Integer::sum);
                maps[j].merge(dis, 1, Integer::sum);
            }
        }
        int res = 0;
        for(Map<Integer, Integer> map : maps){
            for(Integer count : map.values()) {
                if(count > 1){
                    res += count * (count - 1);
                }
            }
        }
        return res;
    }
}
