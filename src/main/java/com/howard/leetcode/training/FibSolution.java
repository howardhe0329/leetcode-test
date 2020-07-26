package com.howard.leetcode.training;

public class FibSolution {

    public int fib(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibSolution solution = new FibSolution();
        int res = solution.fib(10);
        System.out.println(res);
    }
}
