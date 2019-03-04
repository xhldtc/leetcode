package com.problems.w;

/**
 * @author xhldtc on 2019-03-04.
 */
public class WordSearch {

    static final int[][] towards = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return true;
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    mark[i][j] = true;
                    boolean result = dfs(board, mark, 1, word, i, j);
                    mark[i][j] = false;
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] mark, int depth, String word, int row, int col) {
        if (depth == word.length()) {
            return true;
        }
        for (int i = 0; i < towards.length; i++) {
            int rr = row + towards[i][0];
            int cc = col + towards[i][1];
            if (rr >= 0 && rr < board.length && cc >= 0 && cc < board[0].length && board[rr][cc] == word.charAt(depth)
                    && !mark[rr][cc]) {
                mark[rr][cc] = true;
                boolean result = dfs(board, mark, depth + 1, word, rr, cc);
                mark[rr][cc] = false;
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new WordSearch().exist(board, "SEE"));
    }
}
