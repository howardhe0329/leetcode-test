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
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        return nums[left];
    }

    public int findMax(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) left = mid;
            else right = mid - 1;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        RotateSortedArraySearch rotateSortedArraySearch = new RotateSortedArraySearch();
        int[] mums = new int[] {3,4,5,1,2};
        int res = rotateSortedArraySearch.findMin(mums);
        System.out.println(res);
        res = rotateSortedArraySearch.findMax(mums);
        System.out.println(res);

    }
}
