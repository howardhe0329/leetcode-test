package com.howard.leetcode.array;

import java.util.Arrays;

public class Solution26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int nonRepeatIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1])
                nums[++nonRepeatIndex] = nums[i];
        }
        return nonRepeatIndex + 1;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = new int[]{1, 1, 2};
        int res = solution26.removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));

        System.out.println("---------------------------------------------------------------------------------");
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        res = solution26.removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }
}
