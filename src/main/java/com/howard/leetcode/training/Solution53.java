package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num : nums) {
            if (sum > 0) sum += num;
            else sum = num; // 把前面的都舍弃掉，从num所在位置开始重新计算
            ans = Math.max(sum, ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int res = solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(res);


    }
}
