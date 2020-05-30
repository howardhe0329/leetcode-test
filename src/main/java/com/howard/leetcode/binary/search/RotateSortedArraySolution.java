package com.howard.leetcode.binary.search;

/**
 * 搜索旋转排序数组
 *
 * @author howard he
 * @create 2019-01-07 14:24
 */
public class RotateSortedArraySolution {

    /**
     *
     * 解题思路：
     * 旋转有序数组，如：[4, 5, 6, 7, 0, 1, 2] ，只要从中间劈开，那么肯定有一边肯定是有序的。
     * 只要我们我对有序的一边进行判断，left和right指针怎么移动就可以。
     * 那么就是是先判断 nums[left] 是否小于等于 nums[mid]，如成立就判断target是否在这个区间内
     * target >= nums[left] && target < nums[mid]，如成立就让right 指向 mid - 1; 否则 left 指向 mid + 1。
     *
     * 同理，右边也是一样的逻辑
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 证明数组左半边是有序的
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // 证明数组右半边是有序的
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        // 找出数组中的最大值
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] < nums[lo]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        int n = nums.length;
        int bias = (lo + n) - (n - 1);
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            int mid_change = (mid + bias) % nums.length;
            int value = nums[mid_change];
            if (target == value) {
                return mid_change;
            }
            if (target < value) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
