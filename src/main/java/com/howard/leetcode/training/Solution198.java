package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution198 {

    public int rob(int[] nums) {
//        return recursive(nums, nums.length - 1);
//        return recursiveMemo(nums, nums.length - 1, new int[nums.length]);
//        return bottomUp(nums, nums.length);
        return bottomUp(nums);
    }

    /**
     * recursive
     * @param nums
     * @param n
     * @return
     */
    private int recursive(int[] nums, int n) {
        if (n < 0) return 0;
        return Math.max(recursive(nums, n - 2) + nums[n], recursive(nums, n - 1));
    }

    private int recursiveMemo(int[] nums, int n, int[] memo) {
        if (n < 0) return 0;
        if (memo[n] != 0) return memo[n];
        return memo[n] = Math.max(recursiveMemo(nums, n - 2, memo) + nums[n], recursiveMemo(nums, n - 1, memo));
    }

    /**
     *
     * 子问题：f(n) = Math.max(f(n-2) + nums[n], f(n-1))
     * DP方程 dp[i] = MAX(dp[i - 1], dp[i - 2] + num)
     * @param nums
     * @param n
     * @return
     */
    private int bottomUp(int[] nums, int n) {
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[n];
    }

    private int bottomUp(int[] nums) {
        int one = 0, two = 0;
        for (int num : nums) {
            int temp = Math.max(two, one + num);
            one = two;
            two = temp;
        }
        return two;
    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        int res = solution198.rob(new int[]{1, 2, 3, 1});
        System.out.println(res);

        res = solution198.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(res);
    }
}
