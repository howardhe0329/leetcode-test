package com.howard.leetcode.training;

public class Solution62_1 {

    public int uniquePaths(int m, int n) {
//        return recursive(m - 1, n - 1);
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
        return memo[m][n] = recursive(m - 1, n) + recursive(m, n - 1);
    }

    private int bottomUp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution62_1 solution62_1 = new Solution62_1();
        int res = solution62_1.uniquePaths(3, 2);
        System.out.println(res);

        res = solution62_1.uniquePaths(7, 3);
        System.out.println(res);

        res = solution62_1.uniquePaths(100, 80);
        System.out.println(res);
    }
}
