package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution309 {

    public int maxProfit(int[] prices) {
        // cash 意思持有现金，不买；stock 意思持有股票，不卖；preSell 上次卖股票的金额
        int cash = 0, stock = Integer.MIN_VALUE, preSell = 0;
        for (int price : prices) {
            int tmp = cash;
            cash = Math.max(cash, stock + price);
            stock = Math.max(preSell - price, stock);
            preSell = tmp;
        }
        return cash;
    }

    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        int[] prices = new int[]{1, 2, 3, 0, 2};
        int res = solution309.maxProfit(prices);
        System.out.println(res);
    }
}
