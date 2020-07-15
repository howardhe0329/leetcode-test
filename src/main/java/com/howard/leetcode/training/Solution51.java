package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution51 {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(board, 0, result);
        return result;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> result) {
        if (colIndex == board.length) {
            result.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!validate(board, i, colIndex)) continue;
            board[i][colIndex] = 'Q';
            dfs(board, colIndex + 1, result);
            board[i][colIndex] = '.';
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> res = solution51.solveNQueens(4);
        System.out.println(res);
    }
}
