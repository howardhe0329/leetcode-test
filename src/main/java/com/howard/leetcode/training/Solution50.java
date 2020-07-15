package com.howard.leetcode.training;

public class Solution50 {

    public double myPow(double x, int n) {
        return 1.0;
    }



    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double res = solution50.myPow(2, 10);
        System.out.println(res);

        res = solution50.myPow(2, -2);
        System.out.println(res);

        res = solution50.myPow(2, 0);
        System.out.println(res);

    }

}
