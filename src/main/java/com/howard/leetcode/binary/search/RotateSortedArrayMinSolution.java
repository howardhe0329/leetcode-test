package com.howard.leetcode.binary.search;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @author howard he
 * @create 2019-01-07 17:19
 */
public class RotateSortedArrayMinSolution {

    /**
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
