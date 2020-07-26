package com.howard.leetcode.training;

import java.util.Arrays;

public class Solution62 {

    public int uniquePaths(int m, int n) {
//        int[][] memo = new int[m][n];
//        return recursiveMemo(m - 1, n - 1, memo);
        return bottomUp(m, n);
    }

    private int recursive(int m, int n) {
        if (m == 0 || n == 0) return 1;
        return recursive(m - 1, n) + recursive(m, n - 1);
    }

    private int recursiveMemo(int m, int n, int[][] memo) {
        if (m == 0 || n == 0) return 1;
        if (memo[m][n] != 0) return memo[m][n];
        memo[m][n] = recursiveMemo(m - 1, n, memo) + recursiveMemo(m, n - 1, memo);
        return memo[m][n];
    }

    private int bottomUp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) dp[i][j] = 1;
                else if (j == 1) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution62 solution62 = new Solution62();
        int res = solution62.uniquePaths(3, 2);
        System.out.println(res);

        res = solution62.uniquePaths(7, 3);
        System.out.println(res);
    }
}
