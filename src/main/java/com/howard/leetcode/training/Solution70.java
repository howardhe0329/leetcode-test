package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution70 {

    public int climbStairs(int n) {
//        return recursive(n);
//        int[] memo = new int[n + 1];
//        return recursiveMemo(n, memo);
//        return bottomUp(n);
        return bottomUp1(n);
    }

    private int recursive(int n) {
        if (n <= 3) return n;
        return recursive(n - 1) + recursive(n - 2);
    }

    private int recursiveMemo(int n, int[] memo) {
        if (n <= 3) return n;
        if (memo[n] != 0) return memo[n];
        return memo[n] = recursiveMemo(n - 1, memo) + recursiveMemo(n - 2, memo);
    }

    private int bottomUp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 3) dp[i] = i;
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private int bottomUp1(int n) {
        if (n <= 3) return n;
        int one = 1, two = 2, ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = two + one;
            one = two;
            two = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
//        int res = solution70.climbStairs(2);
//        System.out.println(res);
//
//        res = solution70.climbStairs(3);
//        System.out.println(res);
//
        int res = solution70.climbStairs(4);
        System.out.println(res);

        res = solution70.climbStairs(50);
        System.out.println(res);
    }
}
