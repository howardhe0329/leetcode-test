package com.howard.leetcode.training;

public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int coin : bills) {
            if (coin == 5) five++;
            else if (coin == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }
            if (five < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution860 solution860 = new Solution860();
        boolean res = solution860.lemonadeChange(new int[]{5, 5, 5, 10, 20});
        System.out.println(res);
    }
}
