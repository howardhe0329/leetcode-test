package com.howard.leetcode.training;

import sun.font.DelegatingShape;

/**
 * @author howard
 */
public class Solution91 {

    /**
     * f(n) = f(n-1) + f(n-2)
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) return 0;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            dp[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 1] + dp[i + 2]: dp[i + 1];
        }
        return dp[0];
    }



    public static void main(String[] args) {
        Solution91 solution91 = new Solution91();
        int res = 0;
        res = solution91.numDecodings("10");
        System.out.println(res);

        res = solution91.numDecodings("226");
        System.out.println(res);

        res = solution91.numDecodings("6212");
        System.out.println(res);
    }
}
