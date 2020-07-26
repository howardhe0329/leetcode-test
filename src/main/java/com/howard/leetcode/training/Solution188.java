package com.howard.leetcode.training;

import java.util.Arrays;

/**
 * @author howard
 */
public class Solution188 {

    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length >>> 1) {
            int cash = 0, stock = Integer.MIN_VALUE;
            for (int price: prices) {
                int oldCash = cash;
                cash = Math.max(cash, stock + price);
                stock = Math.max(stock, oldCash - price);
            }
            return cash;
        }
        int[] cash = new int[k + 1];
        int[] stock = new int[k + 1];
        Arrays.fill(stock, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int i = k; i > 0; i--) {
                cash[i] = Math.max(cash[i], stock[i] + price);
                stock[i] = Math.max(stock[i], cash[i - 1] - price);
            }
        }
        return cash[k];
    }

    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        int res = solution188.maxProfit(2, new int[]{2, 4, 1});
        System.out.println(res);

        res = solution188.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(res);
    }
}
