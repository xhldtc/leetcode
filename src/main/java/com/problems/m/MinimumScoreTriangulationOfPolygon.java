package com.problems.m;

public class MinimumScoreTriangulationOfPolygon {

    public int minScoreTriangulation(int[] A) {
        int[][] mem = new int[A.length][A.length];
        return solve(A, mem, 0, A.length - 1);
    }

    int solve(int[] A, int[][] mem, int start, int end) {
        int s = start % A.length;
        int e = end % A.length;
        if (mem[s][e] != 0) {
            return mem[s][e];
        } else if (start + 2 == end) {
            mem[s][e] = A[start % A.length] * A[(start + 1) % A.length] * A[end % A.length];
            return mem[s][e];
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = start + 2; i < end; i++) {
                int res = solve(A, mem, start, i) + solve(A, mem, i, start + A.length);
                min = Math.min(min, res);
            }
            mem[s][e] = min;
            return min;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinimumScoreTriangulationOfPolygon().minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }
}
