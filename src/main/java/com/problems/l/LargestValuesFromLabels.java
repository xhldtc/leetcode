package com.problems.l;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class LargestValuesFromLabels {

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[] count = new int[20001];
        List<Pair<Integer, Integer>> list = new ArrayList<>(values.length);
        for (int i = 0; i < values.length; i++) {
            list.add(new Pair<>(values[i], labels[i]));
            if (count[labels[i]] < use_limit) {
                count[labels[i]]++;
            }
        }
        list.sort((p1, p2) -> Integer.compare(p2.getKey(), p1.getKey()));
        int total = 0, res = 0;
        for (Pair<Integer, Integer> p : list) {
            if (total < num_wanted) {
                int label = p.getValue();
                if (count[label] > 0) {
                    res += p.getKey();
                    count[label]--;
                    total++;
                }
            } else {
                break;
            }
        }
        return res;
    }
}
