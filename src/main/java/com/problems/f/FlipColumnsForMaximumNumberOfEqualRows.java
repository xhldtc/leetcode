package com.problems.f;

import java.util.*;
import java.util.stream.Collectors;

public class FlipColumnsForMaximumNumberOfEqualRows {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] m : matrix) {
            List<Integer> list = Arrays.stream(m).boxed().collect(Collectors.toList());
            List<Integer> pair = pair(list);
            if (!map.containsKey(list)) {
                map.put(list, 1);
                map.put(pair, 1);
            } else {
                map.merge(list, 1, Integer::sum);
                map.merge(pair, 1, Integer::sum);
            }
            res = Math.max(map.get(list), res);
        }
        return res;
    }

    List<Integer> pair(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int num : list) {
            res.add(1 - num);
        }
        return res;
    }
}
