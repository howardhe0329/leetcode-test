package com.howard.leetcode.training;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution529 {

    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int rows = board.length, cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            if (board[x][y] == 'M') {
                board[x][y] = 'X';
            } else {
                int count = 0;
                for (int i = 0; i < directions.length; i++) {
                    int newX = x + directions[i][0];
                    int newY = y + directions[i][1];
                    if (!inArea(newX, newY, rows, cols)) continue;
                    if (board[newX][newY] == 'M' || board[newX][newY] == 'X') count++;
                }
                if (count > 0) {
                    board[x][y] = (char) (count + '0');
                } else {
                    board[x][y] = 'B';
                    for (int i = 0; i < directions.length; i++) {
                        int newX = x + directions[i][0];
                        int newY = y + directions[i][1];
                        if (!inArea(newX, newY, rows, cols)) continue;
                        if (board[newX][newY] == 'E') {
                            queue.offer(new int[]{newX, newY});
                            board[newX][newY] = 'B';
                        }
                    }
                }
            }
        }
        return board;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        Solution529 solution529 = new Solution529();
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click = {3, 0};
        char[][] res = solution529.updateBoard(board, click);
        for (char[] item : res) {
            System.out.println(Arrays.toString(item));
        }
        System.out.println("------------------------------------------------");
        char[][] board1 = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        int[] click1 = {1, 2};
        res = solution529.updateBoard(board1, click1);
        for (char[] item : res) {
            System.out.println(Arrays.toString(item));
        }
    }
}
