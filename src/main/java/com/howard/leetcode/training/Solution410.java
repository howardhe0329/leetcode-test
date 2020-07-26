package com.howard.leetcode.training;

/**
 * @author howard
 */
public class Solution410 {

    /**
     * 二分查找 + 贪心
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        long lo = 0, hi = 0;
        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }
        while (lo < hi) {
            long mid = (lo + hi) / 2;
            if (check(nums, mid, m))
                hi = mid;
            else
                lo = mid + 1;
        }
        return (int)lo;
    }

    private boolean check(int[] nums, long x, int m) {
        long sum = 0;
        int cnt = 1;
        for (int num : nums) {
            if (sum + num > x) {
                cnt++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        Solution410 solution410 = new Solution410();
        int res = solution410.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        System.out.println(res);
    }
}
