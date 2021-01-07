package com.problems.k;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> Integer.compare(dis(y), dis(x)));
        for (int[] p : points) {
            if (q.size() < K) {
                q.offer(p);
            } else if (dis(p) < dis(q.peek())) {
                q.poll();
                q.offer(p);
            }
        }
        int[][] res = new int[K][2];
        int index = 0;
        while (!q.isEmpty()) {
            res[index++] = q.poll();
        }
        return res;
    }

    int dis(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}
