package com.howard.leetcode.array;

/**
 * 数组中有多少个逆序对
 *
 * @author howard he
 * @create 2019-03-07 10:21
 */
public class ReverseOrderArray {

    /**
     * 查找数组中逆序对的个数
     * 暴力解决
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
    public int countReverseOrder(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                   cnt ++;
                }
            }
        }
        return cnt;
    }

    /**
     * 分治算法
     * 时间复杂度O(nlogn)
     * @param nums
     * @return
     */
    public int countReverseOrder1(int[] nums) {
        int cnt = 0;
        if (nums == null || nums.length == 0) {
            return cnt;
        }

        return cnt;
    }

    private int helper(int[] nums, int left, int right) {
        return 0;
    }
}
