package com.problems.n;

import javafx.util.Pair;

import java.util.*;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        List<Pair<Integer, Integer>>[] list = new List[N];
        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            if (list[u] == null) {
                list[u] = new ArrayList<>();
            }
            list[u].add(new Pair<>(v, time[2]));
        }
        int[] dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K - 1] = 0;
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
        q.add(new Pair<>(K - 1, 0));
        boolean[] flag = new boolean[N];
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            if(flag[p.getKey()]){
                continue;
            }
            flag[p.getKey()] = true;
            if (list[p.getKey()] != null) {
                for (Pair<Integer, Integer> to : list[p.getKey()]) {
                    if (p.getValue() + to.getValue() < dis[to.getKey()]) {
                        dis[to.getKey()] = p.getValue() + to.getValue();
                        q.add(new Pair<>(to.getKey(), dis[to.getKey()]));
                    }
                }
            }
        }
        int res = 0;
        for (int d : dis) {
            res = Math.max(res, d);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime().networkDelayTime(new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        }, 4, 2));
    }
}
