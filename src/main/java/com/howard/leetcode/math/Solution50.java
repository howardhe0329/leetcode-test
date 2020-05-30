package com.howard.leetcode.math;

/**
 * 求x的n次幂
 *
 * @author howard he
 * @create 2019-03-11 14:27
 */
public class Solution50 {

    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            if (x == 1 || x == -1) {
                return 1.0;
            } else {
                return 0.0;
            }
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double result = 1.0;
        for (double i = x; n > 0 ; n >>= 1) {
            // odd
            if ((n & 1) == 1) {
                result *= i;
            }
            i *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow(2, Integer.MIN_VALUE));
        System.out.println(Math.pow(1, Integer.MIN_VALUE));
    }
}
