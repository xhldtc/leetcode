package com.problems.u;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        return solve(n, res);
    }

    int solve(int n, int[] res) {
        if (res[n] > 0)
            return res[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += solve(i - 1, res) * solve(n - i, res);
        }
        res[n] = sum;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(19));
    }
}
