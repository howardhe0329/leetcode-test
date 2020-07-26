package com.howard.leetcode.training;

import java.util.LinkedList;
import java.util.Queue;

public class Solution200_1 {

    public int numIslands(char[][] grid) {
        int rows;
        if ((rows = grid.length) == 0) return 0;
        int cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, rows, cols, marked, directions, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, int rows, int cols, boolean[][] marked, int[][] directions, char[][] grid) {
        marked[i][j] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * cols + j);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curX = cur / cols;
            int curY = cur % cols;
            for (int k = 0; k < directions.length; k++) {
                int newX = curX + directions[k][0];
                int newY = curY + directions[k][1];
                if (inArea(newX, newY, rows, cols) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                    queue.offer(newX * cols + newY);
                    marked[newX][newY] = true;
                }
            }
        }

    }

    private boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        Solution200_1 solution200_1 = new Solution200_1();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int res = solution200_1.numIslands(grid);
        System.out.println(res);

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        res = solution200_1.numIslands(grid);
        System.out.println(res);
    }
}
