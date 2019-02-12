package com.problems.v;

import java.util.Arrays;

/**
 * @author xhldtc on 2019-02-10.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[] check = new boolean[9];
        for (int i = 0; i < board.length; i++) {
            reset(check);
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (!check[digit]) {
                        check[digit] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            reset(check);
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (!check[digit]) {
                        check[digit] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkSub(board, i, j, check)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSub(char[][] board, int row, int col, boolean[] check) {
        reset(check);
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    if (!check[digit]) {
                        check[digit] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void reset(boolean[] check) {
        Arrays.fill(check, false);
    }
}
