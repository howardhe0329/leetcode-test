package com.howard.leetcode.eighteen;

/**
 * 搜索二维矩阵
 *
 * @author howard he
 * @create 2019-03-13 14:45
 */
public class Solution3 {

    /**
     *
     * 思路：
     *  先从matrix的右上角开始比较，设为x
     *  1. 如果目标值大于x, 则目标值一定不在这一行 row
     *  2. 如果目标值小于x, 则目标值一定不在这一列 column
     *  3. 直到遍历m + n 次
     * Time complexity: O(m + n)
     * Space complexity: O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r ++;
            } else {
                c --;
            }
        }
        return false;
    }

    /**
     * Binary Search
     *
     * Time complexity: O(mlogn)
     * Space complexity: O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分搜索
     * @param nums
     * @param target
     * @return
     */
    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left =  mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * Brute Force
     * Time complexity: O(m * n)
     * Space complexity: O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
