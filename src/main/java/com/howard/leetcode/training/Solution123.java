package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution123 {

    public int maxProfit(int[] prices) {
        int cash1 = 0, stock1 = Integer.MIN_VALUE;
        int cash2 = 0, stock2 = Integer.MIN_VALUE;
        for (int price : prices) {
            cash2 = Math.max(cash2, stock2 + price);
            stock2 = Math.max(stock2, cash1 - price);
            cash1 = Math.max(cash1, stock1 + price);
            stock1 = Math.max(stock1, -price);
        }
        return cash2;
    }

    public static void main(String[] args) {
        Solution123 solution123 = new Solution123();
        int res = solution123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(res);

        res = solution123.maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(res);

        res = solution123.maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(res);
    }
}
