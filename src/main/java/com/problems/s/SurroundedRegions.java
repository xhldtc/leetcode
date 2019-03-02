package com.problems.s;

import java.util.LinkedList;

/**
 * @author xhldtc on 2019-03-02.
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    bfs(board, mark, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, boolean[][] mark, int row, int col) {
        boolean surround = true;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        mark[row][col] = true;
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            if (curr[0] == 0 || curr[0] == board.length - 1 || curr[1] == 0 || curr[1] == board[0].length - 1) {
                surround = false;
                break;
            }
            int[] up = new int[]{curr[0] - 1, curr[1]};
            if (board[up[0]][up[1]] == 'O' && !mark[up[0]][up[1]]) {
                queue.add(up);
                mark[up[0]][up[1]] = true;
            }
            int[] down = new int[]{curr[0] + 1, curr[1]};
            if (board[down[0]][down[1]] == 'O' && !mark[down[0]][down[1]]) {
                queue.add(down);
                mark[down[0]][down[1]] = true;
            }
            int[] left = new int[]{curr[0], curr[1] - 1};
            if (board[left[0]][left[1]] == 'O' && !mark[left[0]][left[1]]) {
                queue.add(left);
                mark[left[0]][left[1]] = true;
            }
            int[] right = new int[]{curr[0], curr[1] + 1};
            if (board[right[0]][right[1]] == 'O' && !mark[right[0]][right[1]]) {
                queue.add(right);
                mark[right[0]][right[1]] = true;
            }
        }
        bfs(board, row, col, surround ? 'X' : '1');
    }

    private void bfs(char[][] board, int row, int col, char c) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        board[row][col] = c;
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            if (curr[0] - 1 >= 0 && board[curr[0] - 1][curr[1]] == 'O') {
                queue.add(new int[]{curr[0] - 1, curr[1]});
                board[curr[0] - 1][curr[1]] = c;
            }
            if (curr[0] + 1 < board.length && board[curr[0] + 1][curr[1]] == 'O') {
                queue.add(new int[]{curr[0] + 1, curr[1]});
                board[curr[0] + 1][curr[1]] = c;
            }
            if (curr[1] - 1 >= 0 && board[curr[0]][curr[1] - 1] == 'O') {
                queue.add(new int[]{curr[0], curr[1] - 1});
                board[curr[0]][curr[1] - 1] = c;
            }
            if (curr[1] + 1 < board[0].length && board[curr[0]][curr[1] + 1] == 'O') {
                queue.add(new int[]{curr[0], curr[1] + 1});
                board[curr[0]][curr[1] + 1] = c;
            }
        }
    }

    public static void main(String[] args) {
        char[][] borad = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        new SurroundedRegions().solve(borad);
        System.out.println(borad);
    }
}