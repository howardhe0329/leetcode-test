package com.howard.leetcode.training;

public class Solution55_1 {

    public boolean canJump(int[] nums) {
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightmost) return false;
            rightmost = Math.max(rightmost, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution55_1 solution55_1 = new Solution55_1();
        boolean res = solution55_1.canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(res);

    }
}
