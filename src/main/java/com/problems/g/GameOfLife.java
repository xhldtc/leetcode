package com.problems.g;

public class GameOfLife {

    private final int[][] dir = {
            {-1, -1},
            {-1, 0},
            {-1, 1},
            {0, -1},
            {0, 1},
            {1, -1},
            {1, 0},
            {1, 1}
    };

    public void gameOfLife(int[][] board) {
        if (board.length == 0)
            return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCount = liveCount(board, i, j);
                board[i][j] |= (liveCount << 1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int isLive = board[i][j] & 1;
                int liveCount = board[i][j] >> 1;
                if (isLive == 1 && (liveCount == 2 || liveCount == 3))
                    board[i][j] = 1;
                else if (isLive == 0 && liveCount == 3)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }

    int liveCount(int[][] board, int row, int col) {
        int count = 0;
        for (int[] d : dir) {
            int r = row + d[0], c = col + d[1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && (board[r][c] & 1) == 1)
                count++;
        }
        return count;
    }
}
