package com.howard.leetcode.eighteen;

/**
 * 合并两个有序的数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @author howard he
 * @create 2019-03-14 09:05
 */
public class Solution4 {

    /**
     *
     * Time complexity: O(M + N)
     * Space complexity: O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int i = nums1.length -1;
        while (i >= 0) {
            if (m >= 0 && n >= 0) {
                if (nums1[m] > nums2[n]) {
                    nums1[i] = nums1[m--];
                } else {
                    nums1[i] = nums2[n--];
                }
            } else if (n >= 0) {
                nums1[i] = nums2[n--];
            } else {
                return;
            }
            i --;
        }
    }


    /**
     *
     * Time complexity: O(M + N)
     * Space complexity: O(M)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int idx1 = 0;
        int idx2 = 0;
        int i = 0;
        while (idx1 < m && idx2 < n) {
            if (nums1[idx1] <= nums2[idx2]) {
                temp[i] = nums1[idx1++];
            } else {
                temp[i] = nums2[idx2++];
            }
            i++;
        }
        while (idx1 < m) {
            temp[i] = nums1[idx1++];
            i ++;
        }
        while (idx2 < n) {
            temp[i] = nums2[idx2++];
            i++;
        }
        for (int j = 0; j < nums1.length; j++) {
            nums1[j] = temp[j];
        }
    }
}
