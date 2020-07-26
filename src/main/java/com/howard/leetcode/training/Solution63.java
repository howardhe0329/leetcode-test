package com.howard.leetcode.training;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        return bottomUp(obstacleGrid, m, n);
    }

    public int bottomUp(int[][] obstacleGrid, int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        int res = solution63.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0}, {0, 1, 0}, {0, 0, 0}
        });
        System.out.println(res);

        res = solution63.uniquePathsWithObstacles(new int[][]{
                {1, 0}
        });
        System.out.println(res);
    }
}
