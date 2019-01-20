package com.problems.m;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xhldtc on 2019-01-20.
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, bfs(grid, i, j));
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int row, int col) {
        Deque<Point> deque = new LinkedList<>();
        deque.addLast(new Point(row, col));
        int sum = 0, maxRow = grid.length, maxCol = grid[0].length;
        grid[row][col] = 0;
        while (!deque.isEmpty()) {
            Point curr = deque.removeFirst();
            sum++;
            if (curr.col - 1 >= 0 && grid[curr.row][curr.col - 1] == 1) {
                grid[curr.row][curr.col - 1] = 0;
                deque.addLast(new Point(curr.row, curr.col - 1));
            }
            if (curr.col + 1 < maxCol && grid[curr.row][curr.col + 1] == 1) {
                grid[curr.row][curr.col + 1] = 0;
                deque.addLast(new Point(curr.row, curr.col + 1));
            }
            if (curr.row - 1 >= 0 && grid[curr.row - 1][curr.col] == 1) {
                grid[curr.row - 1][curr.col] = 0;
                deque.addLast(new Point(curr.row - 1, curr.col));
            }
            if (curr.row + 1 < maxRow && grid[curr.row + 1][curr.col] == 1) {
                grid[curr.row + 1][curr.col] = 0;
                deque.addLast(new Point(curr.row + 1, curr.col));
            }
        }
        return sum;
    }

    static class Point {

        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
