package com.howard.leetcode.training;

public class Solution367 {

    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while (low <= high) {
            long mid = (high + low) >>> 1;
            if (mid * mid == num) return true;
            else if (mid * mid < num)
                low = (int) mid + 1;
            else
                high = (int) mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution367 solution367 = new Solution367();
        boolean res = solution367.isPerfectSquare(900);
        System.out.println(res);
    }
}
