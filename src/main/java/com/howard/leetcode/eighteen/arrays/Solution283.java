package com.howard.leetcode.eighteen.arrays;

/**
 * 移动零
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author howard he
 * @create 2019-03-19 09:51
 */
public class Solution283 {

    /**
     * 运用快慢指针思想
     * Timecomplexity: O(N)
     * Spacecomplexity: O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
