package com.problems.a;

import java.util.*;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] A) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for(int num: A){
            if(num>0){
                pos.add(num);
            } else if(num<0){
                neg.add(num);
            }
        }
        if(pos.size() % 2 !=0 || neg.size() % 2 !=0) {
            return false;
        }
        Collections.sort(pos);
        neg.sort((x, y) -> Integer.compare(y, x));
        return valid(pos) && valid(neg);
    }

    boolean valid(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num: list){
            map.merge(num, 1, Integer::sum);
        }
        for(Integer num: list){
            Integer count = map.get(num);
            if(count > 0){
                Integer doub = map.get(num * 2);
                if(doub != null && doub > 0){
                    map.put(num , count - 1);
                    map.put(num * 2, doub -1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
