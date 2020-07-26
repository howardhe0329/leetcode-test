package com.howard.leetcode.training;

public class Solution33 {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int bias = getMin(nums);

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int realMid = (bias + mid) % nums.length;
            if (target == nums[realMid]) return realMid;
            else if (target < nums[realMid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }

    private int getMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int res = solution33.search(nums, 0);
        System.out.println(res);

        res = solution33.search(nums, 3);
        System.out.println(res);
    }
}
