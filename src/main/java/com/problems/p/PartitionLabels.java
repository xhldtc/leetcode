package com.problems.p;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); ) {
            char ch = S.charAt(i);
            int index = S.lastIndexOf(ch);
            if (index == i) {
                res.add(1);
                i++;
            } else {
                int end = index;
                for (int j = i + 1; j < end; j++) {
                    char c = S.charAt(j);
                    int ind = S.lastIndexOf(c);
                    if (ind > end) {
                        end = ind;
                    }
                }
                res.add(end - i + 1);
                i = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
