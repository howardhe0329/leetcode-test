package com.howard.leetcode.training;

public class Solution1143_1 {

    public int longestCommonSubsequence(String text1, String text2) {
//        return recursive(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
//        int[][] memo = new int[text1.length() + 1][text2.length() + 1];
//        return recursiveMemo(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length(), memo);
//        return bottomUp(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
        return bottomUp1(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
    }

    private int recursive(char[] c1, char[] c2, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (c1[m - 1] ==  c2[n - 1]) return recursive(c1, c2, m - 1, n - 1) + 1;
        else return Math.max(recursive(c1, c2, m - 1, n), recursive(c1, c2, m, n - 1));
    }

    private int recursiveMemo(char[] c1, char[] c2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) return 0;
        if (memo[m][n] != 0) return memo[m][n];
        if (c1[m - 1] == c2[n - 1]) return memo[m][n] = recursiveMemo(c1, c2, m - 1, n - 1, memo) + 1;
        else return memo[m][n] = Math.max(recursiveMemo(c1, c2, m - 1, n, memo), recursiveMemo(c1, c2, m, n - 1, memo));
    }

    private int bottomUp(char[] c1, char[] c2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (c1[i - 1] == c2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    private int bottomUp1(char[] c1, char[] c2, int m, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (c1[i - 1] == c2[j - 1]) dp[j] = prev + 1;
                else dp[j] = Math.max(dp[j - 1], dp[j]);
                prev = temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution1143_1 solution1143_1 = new Solution1143_1();
        int res = solution1143_1.longestCommonSubsequence("abcde", "ace");
        System.out.println(res);

        res = solution1143_1.longestCommonSubsequence("abc", "abc");
        System.out.println(res);

        res = solution1143_1.longestCommonSubsequence("abc", "def");
        System.out.println(res);
    }
}
