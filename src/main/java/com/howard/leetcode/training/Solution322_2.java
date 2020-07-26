package com.howard.leetcode.training;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author howard
 */
public class Solution322_2 {

    public int coinChange(int[] coins, int amount) {
//        return bfs(coins, amount);
        return bottomUp(coins, amount);
    }

    /**
     * DP
     * 1. subproblems
     * 2. DP array:
     * 3. DP方程
     *
     * f(n) = min(f(n-k), for k in [1, 2, 5]) + 1
     * @param coins
     * @param amount
     * @return
     */
    private int bottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] < min)
                    min = dp[i - coin] + 1;
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private int bfs(int[] coins, int amout) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amout);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int rest = queue.poll();
                for (int j = 0; j < coins.length; j++) {
                    int temp = rest - coins[j];
                    if (temp == 0) return count;
                    if (temp > 0) queue.offer(temp);
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution322_2 solution322_2 = new Solution322_2();

        int res = solution322_2.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);

        res = solution322_2.coinChange(new int[]{186, 419, 83, 408}, 6249);
        System.out.println(res);

    }
}
