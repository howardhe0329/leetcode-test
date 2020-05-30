package com.howard.leetcode.binary.search;

/**
 * 二分查找代码模板
 *
 * @author howard he
 * @create 2019-01-07 21:48
 */
public class BinarySearchTemplate {

    /**
     * 模板一
     * 最基本的二分查找
     *
     * 用于查找可以通过访问数组中的单个索引来确定的元素或条件。
     *
     * @param nums
     * @param target
     * @return
     */
    public int template1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 模板二
     *
     * 用于查找需要访问数组中当前索引及其直接右邻居索引的元素或条件。
     * @param nums
     * @param target
     * @return
     */
    public int template2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // Post-processing
        // End condition left == right
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * 模板三
     *
     * 用于搜索需要访问当前索引及其在数组中的直接左右邻居索引的元素或条件。
     *
     * @param nums
     * @param target
     * @return
     */
    public int template3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
