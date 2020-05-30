package com.howard.leetcode.binary.search;

/**
 * 寻找蜂值
 *
 * @author howard he
 * @create 2019-01-07 16:35
 */
public class FindPeakElementSolution {

    /**
     * 寻找蜂值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
