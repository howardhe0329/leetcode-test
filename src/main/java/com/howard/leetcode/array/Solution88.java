package com.howard.leetcode.array;

import java.util.Arrays;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] > nums2[right])
                nums1[left + right + 1] = nums1[left--];
            else
                nums1[left + right + 1] = nums2[right--];
        }
        while (left >= 0) {
            nums1[left + right + 1] = nums1[left--];
        }
        while (right >= 0) {
            nums1[left + right + 1] = nums2[right--];
        }
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{0, 5, 6};
        solution88.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
