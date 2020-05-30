package com.howard.leetcode.array;

/**
 * @author howard he
 * @create 2019-03-12 09:26
 */
public class Solution122 {

    public int maxProfit(int[] nums) {
        int profit = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                profit += nums[i + 1] - nums[i];
            }
        }
        return profit;
    }
}
