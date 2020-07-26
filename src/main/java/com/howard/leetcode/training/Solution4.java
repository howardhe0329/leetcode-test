package com.howard.leetcode.training;

public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {   // i 需要增大
                iMin = i + 1;
            } else if (i != 0 && j != n && nums1[i - 1] > nums2[j]){
                iMax = i - 1;
            } else{
                int maxLeft;
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if (((m + n) & 1) == 1) return maxLeft; // 奇数，不用考虑右半部分

                int minRight;
                if (i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums2[j], nums1[i]);

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        boolean even = (len & 1) == 0;
        int i1 = 0, i2 = 0, left = -1, right = -1;
        int half = len / 2;
        while (half >= 0) {
            left = right;
            if (i1 < m && (i2 >= n || nums1[i1] < nums2[i2]))
                right = nums1[i1++];
            else
                right = nums2[i2++];
            half--;
        }
        if (even)
            return (left + right) / 2.0;
        return right;
    }

    /**
     * 合并两个有序数组，然后找出中位数
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < merged.length; i++) {
            if (i1 < m && i2 < n) {
                if (nums1[i1] <= nums2[i2])
                    merged[i] = nums1[i1++];
                else
                    merged[i] = nums2[i2++];
            } else if (i1 < m) {
                merged[i] = nums1[i1++];
            } else if (i2 < n) {
                merged[i] = nums2[i2++];
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();

        double res = solution4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(res);

    }
}
