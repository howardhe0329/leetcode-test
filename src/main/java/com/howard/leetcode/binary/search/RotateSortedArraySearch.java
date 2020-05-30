package com.howard.leetcode.binary.search;

/**
 * 旋转有序数组查找最大值或最小值
 *
 * @author howard he
 * @create 2019-01-07 22:04
 */
public class RotateSortedArraySearch {

    /**
     * 找到最小值
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int findMax(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
