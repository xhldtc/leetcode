package com.problems.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            int c = count == null ? 1 : (count + 1);
            map.put(num, c);
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(map.keySet()), res, new HashMap<>(), map, 0);
        return res;
    }

    void dfs(List<Integer> keys, List<List<Integer>> res, Map<Integer, Integer> curr,
             Map<Integer, Integer> countMap, int depth) {
        if (depth == keys.size()) {
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : curr.entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                for (int i = 0; i < value; i++) {
                    list.add(key);
                }
            }
            res.add(list);
            return;
        }
        int key = keys.get(depth), count = countMap.get(key);
        for (int i = 0; i <= count; i++) {
            curr.put(key, i);
            dfs(keys, res, curr, countMap, depth + 1);
        }
    }
}
