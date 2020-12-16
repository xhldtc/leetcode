package com.problems.l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestHappyString {

    public String longestDiverseString(int a, int b, int c) {
        int[][] nodes = new int[][]{
                {a, 0},
                {b, 1},
                {c, 2}
        };
        Arrays.sort(nodes, (n1, n2) -> Integer.compare(n2[0], n1[0]));
        List<StringBuilder> list = new ArrayList<>();
        int size = nodes[0][0] / 2;
        char ch = (char) ('a' + nodes[0][1]);
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            sb.append(ch);
            list.add(sb);
        }
        if (nodes[0][0] % 2 == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(ch);
            list.add(sb);
        }
        int remain = nodes[1][0] + nodes[2][0];
        if (remain < list.size() - 1) {
            for (int i = 0; i < nodes[1][0]; i++) {
                ch = (char) ('a' + nodes[1][1]);
                list.get(i).append(ch);
            }
            for (int i = nodes[1][0]; i < remain; i++) {
                ch = (char) ('a' + nodes[2][1]);
                list.get(i).append(ch);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < remain + 1; i++) {
                sb.append(list.get(i));
            }
            return sb.toString();
        } else {
            for (int i = 0; i < nodes[1][0]; i++) {
                ch = (char) ('a' + nodes[1][1]);
                int index = i % list.size();
                list.get(index).append(ch);
            }
            for (int i = nodes[1][0]; i < remain; i++) {
                ch = (char) ('a' + nodes[2][1]);
                int index = i % list.size();
                list.get(index).append(ch);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
            }
            return sb.toString();
        }
    }
}
