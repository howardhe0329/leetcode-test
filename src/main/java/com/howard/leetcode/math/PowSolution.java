package com.howard.leetcode.math;

/**
 * x的n次幂
 *
 * 1. clarification
 * 2. possible solutions
 *  - brute-force, recursions
 *  - DP
 * 3. Coding
 * 4. Tests
 *
 * // terminator
 * // process
 * // drill down
 * // clear states
 *
 * @author howard he
 * @create 2019-01-03 16:05
 */
public class PowSolution {

    /**
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            if (x == 1 || x == -1) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        double result = 1.0;
        for (double i = x; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                result *= i;
            }
            i *= i;
        }
        return result;
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n >>> 1);
        if ((n & 1) == 1)
            return half * half * x;
        else
            return half * half;
    }

    public static void main(String[] args) {
        PowSolution solution = new PowSolution();
        double res = solution.myPow(2, Integer.MIN_VALUE);
        System.out.println(res);
    }
}
