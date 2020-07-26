package com.howard.leetcode.training;

import java.util.Arrays;

public class SearchForRangeSolution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return result;
        int lo = 0, hi = nums.length -1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid;
        }
        if (nums[lo] != target) return result;
        result[0] = lo;
        lo = 0;
        hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid;
        }
        result[1] = lo;
        return result;
    }



    public static void main(String[] args) {
        SearchForRangeSolution solution = new SearchForRangeSolution();
        int[] res = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(res));

        res = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(res));
    }
}
