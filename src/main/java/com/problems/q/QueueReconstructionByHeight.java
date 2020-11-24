package com.problems.q;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] != o2[0] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]));
        List<int[]> list = new ArrayList<>();
        for (int[] p : people)
            list.add(p[1], p);
        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new QueueReconstructionByHeight().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        })));
    }
}
