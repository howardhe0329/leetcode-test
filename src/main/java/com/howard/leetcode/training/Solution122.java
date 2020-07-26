package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution122 {


    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int cash = 0;
        int hold = -prices[0];
        int preCash = cash;
        int preHold = hold;
        for (int price: prices) {
            cash = Math.max(preCash, preHold + price);
            hold = Math.max(preCash - price, preHold);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null) return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        // 0: 持有现金；1：持有股票；
        // 状态转移：0 -> 1 -> 0 -> 1 -> 0 -> 1 -> 0
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int res = solution122.maxProfit(new int[]{});
        System.out.println(res);

        res = solution122.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);

        res = solution122.maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(res);

        res = solution122.maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(res);
    }
}
