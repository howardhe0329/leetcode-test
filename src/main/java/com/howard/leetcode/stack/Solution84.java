package com.howard.leetcode.stack;

public class Solution84 {

//    public int largestRectangleArea(int[] heights) {
//        int max = 0;
//        for (int i = 0; i < heights.length - 1; i++) {
//            for (int j = i; j < heights.length; j++) {
//                max = Math.max(Math.min(heights[i], heights[j]) * (j - i), max);
//            }
//        }
//        return max;
//    }

    public int largestRectangleArea1(int[] heights) {
        return 0;
    }

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        int[] nums = new int[] {2, 1, 2};
        int res = solution84.largestRectangleArea1(nums);
        System.out.println(res);

        nums = new int[] {1};
        res = solution84.largestRectangleArea1(nums);
        System.out.println(res);

        nums = new int[] {2};
        res = solution84.largestRectangleArea1(nums);
        System.out.println(res);

        nums = new int[] {1, 1};
        res = solution84.largestRectangleArea1(nums);
        System.out.println(res);
    }
}
