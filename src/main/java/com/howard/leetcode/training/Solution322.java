package com.howard.leetcode.training;

import java.util.Arrays;

public class Solution322 {

    private int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        dfs(coins.length - 1, 0, amount, coins);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(int index, int count, int amount, int[] coins) {
        if (amount == 0) {
            result = Math.min(result, count);
            return;
        }
        if (index < 0) return;
        for (int i = amount / coins[index]; i >= 0 && i + count < result; i--) {
            dfs(index - 1, count + i, amount - i * coins[index], coins);
        }
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        int[] coins = new int[]{1, 2, 5};
        int res = solution322.coinChange(coins, 11);
        System.out.println(res);

//        coins = new int[] {2};
//        res = solution322.coinChange(coins, 3);
//        System.out.println(res);
    }
}
