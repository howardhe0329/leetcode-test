package com.howard.leetcode.training;


public class Solution121 {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            if (price < buy) buy = price;
            else profit = Math.max(profit, price - buy);
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int res = solution121.maxProfit(prices);
        System.out.println(res);

        prices = new int[]{7, 6, 4, 3, 1};
        res = solution121.maxProfit(prices);
        System.out.println(res);
    }
}
