package com.howard.leetcode.training;

public class Solution714 {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, stock = Integer.MIN_VALUE;
        for (int price : prices) {
            cash = Math.max(cash, stock + price);
            stock = Math.max(stock, cash - price - fee);
        }
        return cash;
    }

    public static void main(String[] args) {
        Solution714 solution714 = new Solution714();
        int res = solution714.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
        System.out.println(res);

    }
}
