package com.howard.leetcode.training;

import java.util.Arrays;

/**
 * @author howard
 */
public class Solution221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    maxSide = Math.max(dp[i + 1][j + 1], maxSide);
                }
            }
        }
        for (int[] cols : dp) {
            System.out.println(Arrays.toString(cols));
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        Solution221 solution221 = new Solution221();
        int res = solution221.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
        System.out.println(res);
    }
}
