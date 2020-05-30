package com.howard.leetcode.eighteen.arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 *
 *
 * @author howard he
 * @create 2019-03-20 14:41
 */
public class Solution240 {

    /**
     * Time complexity: O(m + n)
     * Space complexity: O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while (n > 0 || m < matrix.length) {
            if (m >= matrix.length || target < matrix[m][n]) {
                n --;
            } else if (n == 0 || target > matrix[m][n]) {
                m ++;
            } else {
                return true;
            }
        }
        return false;
    }
}
