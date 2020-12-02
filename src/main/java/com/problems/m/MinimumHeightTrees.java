package com.problems.m;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        int[] degree = new int[n];
        boolean[] removed = new boolean[edges.length];
        for (int[] arr : edges) {
            degree[arr[0]]++;
            degree[arr[1]]++;
        }
        Set<Integer>[] sets = new Set[n];
        for (int i = 0; i < degree.length; i++) {
            int d = degree[i];
            if (sets[d] == null) {
                sets[d] = new HashSet<>();
            }
            sets[d].add(i);
        }
        int total = n;
        List<Integer> res = solve(sets, total);
        while (res == null) {
            Set<Integer> one = new HashSet<>(sets[1]);
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                if (!removed[i] && (one.contains(edge[0]) || one.contains(edge[1]))) {
                    reduce(degree, sets, edge[0]);
                    reduce(degree, sets, edge[1]);
                    total--;
                    removed[i] = true;
                }
            }
            res = solve(sets, total);
        }
        return res;
    }

    void reduce(int[] degree, Set<Integer>[] sets, int point) {
        int prev = degree[point];
        degree[point]--;
        sets[prev].remove(point);
        if (sets[prev - 1] == null) {
            sets[prev - 1] = new HashSet<>();
        }
        sets[prev - 1].add(point);
    }

    List<Integer> solve(Set<Integer>[] sets, int total) {
        if (sets[1].size() == total) {
            return new ArrayList<>(sets[1]);
        } else if (sets[1].size() + 1 == total) {
            for (int i = 2; i < sets.length; i++) {
                if (sets[i] != null && !sets[i].isEmpty()) {
                    return new ArrayList<>(sets[i]);
                }
            }
        }
        return null;
    }
}
