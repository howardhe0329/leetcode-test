package com.howard.leetcode.array;

public class Solution509 {

    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int res = 0;
        int oneBefore = 1;
        int twoBefore = 0;
        for (int i = 2; i <= N; i++) {
            res = oneBefore + twoBefore;
            twoBefore = oneBefore;
            oneBefore = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution509 solution = new Solution509();
        int res = solution.fib(30);
        System.out.println(res);

    }
}
