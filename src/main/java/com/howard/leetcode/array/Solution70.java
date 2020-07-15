package com.howard.leetcode.array;

public class Solution70 {

    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n-- > 0) {
            a = (b += a) - a;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution70 solution = new Solution70();

        int res = solution.climbStairs(20);
        System.out.println(res);
    }
}
