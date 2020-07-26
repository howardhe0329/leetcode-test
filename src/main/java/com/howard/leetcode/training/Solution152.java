package com.howard.leetcode.training;

public class Solution152 {

    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    /**
     * 暴力求解
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int times = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (j != i) times *= nums[j];
                ans = Math.max(ans, times);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int res = solution152.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(res);

        res = solution152.maxProduct(new int[]{-2,0,-1});
        System.out.println(res);

        res = solution152.maxProduct(new int[]{-2});
        System.out.println(res);
    }
}
