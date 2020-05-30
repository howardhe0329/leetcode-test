package com.howard.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * N-Queens
 *
 * https://leetcode.com/problems/n-queens/
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 * @author howard he
 * @create 2019-04-17 10:27
 */
public class Solution51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], res);
        return res;
    }

    private void dfs(int r, boolean[] cols, boolean[] d1, boolean[] d2, String[] board, List<List<String>> res) {
        if (r == board.length) {
            List<String> boardList = new ArrayList<>(board.length);
            for (String s : board) {
                boardList.add(s);
            }
            res.add(boardList);
            return;
        }
        for (int c = 0; c < board.length; c++) {
            int id1 = r - c + board.length;
            int id2 = 2 * board.length - r - c - 1;
            if (!cols[c] && !d1[id1] && !d2[id2]) {
                char[] row = new char[board.length];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board[r] = new String(row);
                cols[c] = true;
                d1[id1] = true;
                d2[id2] = true;
                dfs(r + 1, cols, d1, d2, board, res);
                cols[c] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> res = solution51.solveNQueens(4);
        for (List<String> row : res) {
            for (String col : row) {
                System.out.printf("%s\n", col);
            }
            System.out.println("-------------------------------");
        }
    }
}
