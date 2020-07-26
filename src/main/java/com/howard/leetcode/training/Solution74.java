package com.howard.leetcode.training;

public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < matrix[mid / n][mid % n])
                hi = mid - 1;
            else
                lo = mid;
        }
        return matrix[hi / n][hi % n] == target;
    }

    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        int[][] matrix = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        boolean res = solution74.searchMatrix(matrix, 3);
        System.out.println(res);
        res = solution74.searchMatrix(matrix, 13);
        System.out.println(res);
    }
}
