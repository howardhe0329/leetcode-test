package com.howard.leetcode.training;

import javax.swing.*;

public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//        return recursionMemo(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length(), dp);
        return dp(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
    }

    /**
     *
     * 利用递归解决问题
     * time complexity O(2^n)
     * space complexity O(m + n)
     * @param c1
     * @param c2
     * @param m
     * @param n
     * @return
     */
    private int recursion(char[] c1, char[] c2, int m, int n) {
        // base case
        if (m == 0 || n == 0)
            return 0;
        if (c1[m - 1] == c2[n - 1])
            return recursion(c1, c2, m - 1, n - 1) + 1;
        else
            return Math.max(recursion(c1, c2, m - 1, n), recursion(c1, c2, m, n - 1));
    }

    /**
     * 记忆化存储 + 递归
     * time complexity: O(m * n)
     * space complexity: O(m * n)
     */
    private int recursionMemo(char[] c1, char[] c2, int m, int n, int[][] dp) {
        // base case
        if (m == 0 || n == 0) return 0;
        if (dp[m][n] != 0) return dp[m][n];
        if (c1[m - 1] == c2[n - 1])
            return recursionMemo(c1, c2, m - 1, n - 1, dp) + 1;
        else
            return dp[m][n] = Math.max(recursionMemo(c1, c2, m - 1, n, dp), recursionMemo(c1, c2, m, n - 1, dp));
    }

    /**
     * DP solution (Bottom up approach)
     * time complexity: O(m * n)
     * space complexity: O(m * n)
     * @param c1
     * @param c2
     * @param m
     * @param n
     */
    private int bottomUp(char[] c1, char[] c2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        // dp table
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;    // 状态转移方程
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);    // 状态转移方程
            }
        }
        return dp[m][n];
    }

    /**
     * DP solution (bottom up approach)
     * using the 1-D array
     * time complexity: O(m * n)
     * space complexity: O(n)
     * @param c1
     * @param c2
     * @param m
     * @param n
     * @return
     */
    private int dp(char[] c1, char[] c2, int m, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (c1[i - 1] == c2[j - 1])
                    dp[j] = prev + 1;
                else
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                prev =temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution1143 solution1143 = new Solution1143();
        int res = solution1143.longestCommonSubsequence("abcde", "ace");
        System.out.println(res);

        res = solution1143.longestCommonSubsequence("abc", "abc");
        System.out.println(res);

        res = solution1143.longestCommonSubsequence("bsbininm", "jmjkbkjkv");
        System.out.println(res);
    }
}
