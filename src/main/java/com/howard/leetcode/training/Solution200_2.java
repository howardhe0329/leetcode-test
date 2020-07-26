package com.howard.leetcode.training;

public class Solution200_2 {

    public int numIslands(char[][] grid) {
        int rows;
        if ((rows = grid.length) == 0) return 0;
        int cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfsMarking(i, j, grid);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfsMarking(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfsMarking(i + 1, j, grid);
        dfsMarking(i - 1, j, grid);
        dfsMarking(i, j + 1, grid);
        dfsMarking(i, j - 1, grid);
    }

    public static void main(String[] args) {
        Solution200_2 solution200_2 = new Solution200_2();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int res = solution200_2.numIslands(grid);
        System.out.println(res);

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        res = solution200_2.numIslands(grid);
        System.out.println(res);
    }
}
