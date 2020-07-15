package com.howard.leetcode.training;

public class Solution55 {

    public boolean canJump(int[] nums) {
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightmost) return false;
            rightmost = Math.max(rightmost, i + nums[i]);
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        int count = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= count) count++;
            else count = 0;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums = new int[] {2,3,1,1,4};
        boolean res = solution55.canJump(nums);
        System.out.println(res);

        nums = new int[] {3,2,1,0,4};
        res = solution55.canJump(nums);
        System.out.println(res);
    }
}
