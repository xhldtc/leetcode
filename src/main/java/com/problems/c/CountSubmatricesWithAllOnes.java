package com.problems.c;

public class CountSubmatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][][] mem = new int[row][col][2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int left = j > 0 ? mem[i][j - 1][0] + 1 : 1;
                int top = i > 0 ? mem[i - 1][j][1] + 1 : 1;
                mem[i][j] = new int[]{left, top};
            }
        }
        int[][][] dp = new int[row][col][2];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = mem[i][j];
                } else if (i == 0) {
                    dp[i][j] = new int[]{mem[i][j][0], 1};
                } else if (j == 0) {
                    dp[i][j] = new int[]{1, mem[i][j][1]};
                } else {
                    if (mat[i][j - 1] == 0) {
                        dp[i][j] = new int[]{1, mem[i][j][1]};
                    } else if (mat[i - 1][j] == 0) {
                        dp[i][j] = new int[]{mem[i][j][0], 1};
                    } else {
                        dp[i][j] = new int[]{
                                Math.min(dp[i - 1][j - 1][0], mem[i][j][0] - 1) + 1,
                                Math.min(dp[i - 1][j - 1][1], mem[i][j][1] - 1) + 1,
                        };
                    }
                }
                res += dp[i][j][0] * dp[i][j][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubmatricesWithAllOnes().numSubmat(new int[][]{
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}
        }));
    }
}
