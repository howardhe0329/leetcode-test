package com.howard.leetcode.training;

import java.util.Arrays;

public class Solution169 {

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candicate = null;
        for (int num : nums) {
            if (count == 0) candicate = num;
            count += (num == candicate) ? 1 : -1;
        }
        return candicate;
    }

    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int[] nums = new int[]{3, 2, 3};
        int res = solution169.majorityElement(nums);
        System.out.println(res);

        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        res = solution169.majorityElement(nums);
        System.out.println(res);
    }
}
