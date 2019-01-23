package com.problems.t;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xhldtc on 2019-01-22.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> line = triangle.get(i);
            List<Integer> prev = triangle.get(i - 1);
            for (int j = 0; j < line.size(); j++) {
                int curr = line.get(j);
                if (j - 1 >= 0 && j < prev.size()) {
                    line.set(j, Math.min(curr + prev.get(j - 1), curr + prev.get(j)));
                } else if (j - 1 >= 0) {
                    line.set(j, curr + prev.get(j - 1));
                } else {
                    line.set(j, curr + prev.get(j));
                }
            }
        }
        return triangle.get(triangle.size() - 1).stream().mapToInt(i -> i).min().getAsInt();
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Triangle().minimumTotal(list));
    }
}
