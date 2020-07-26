package com.howard.leetcode.training;

public class Solution200 {

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过就进行DFS
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, rows, cols, marked, grid, directions);
                }
            }
        }
        return count;
    }

    /**
     * 从坐标(i, j)的点开始进行DFS
     *
     * @param i          i
     * @param j          j
     * @param rows       rows
     * @param cols       cols
     * @param marked     marked
     * @param grid       grid
     * @param directions directions
     */
    private void dfs(int i, int j, int rows, int cols, boolean[][] marked, char[][] grid, int[][] directions) {
        marked[i][j] = true;
        // 4个方向的坐标
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            // 如果不越界，没有被访问过，并且还要是陆地
            if (isArea(newX, newY, rows, cols) && grid[newX][newY] == '1' && !marked[newX][newY])
                dfs(newX, newY, rows, cols, marked, grid, directions);
        }
    }

    private boolean isArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int res = solution200.numIslands(grid);
        System.out.println(res);

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        res = solution200.numIslands(grid);
        System.out.println(res);
    }
}
