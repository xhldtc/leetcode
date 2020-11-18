package com.problems.k;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q.offer(matrix[i][j]);
                if (q.size() > k)
                    q.poll();
            }
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        for (int i = 1; i < 9; i++) {
            System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(matrix, i));
        }
    }
}
