package com.howard.leetcode.training;

import java.util.*;

public class Solution322_1 {

    public int coinChange(int[] coins, int amount) {
        // dp table
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        // 遍历所有状态取值
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            // 求所有选择的最小值
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] < min)
                    min = 1 + dp[i - coin];
            }
            dp[i] = min;
        }
        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution322_1 solution322_1 = new Solution322_1();
        int[] coins = new int[]{1, 2, 5};
        int res = solution322_1.coinChange(coins, 11);
        System.out.println(res);
    }
}
