package com.howard.leetcode.training;

public class Solution1025 {

    public boolean divisorGame(int N) {
//        return N % 2 == 0;
        return bottomUp(N);
    }

    private boolean bottomUp(int N) {
        if (N == 1) return false;
        if (N == 2) return true;
        // dp table
        boolean[] dp = new boolean[N + 1];
        // base case
        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                // 状态转移
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Solution1025 solution1025 = new Solution1025();
        boolean res = solution1025.divisorGame(2);
        System.out.println(res);

        res = solution1025.divisorGame(3);
        System.out.println(res);

        res = solution1025.divisorGame(4);
        System.out.println(res);
    }
}
