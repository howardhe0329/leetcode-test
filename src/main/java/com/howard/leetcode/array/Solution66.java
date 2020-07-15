package com.howard.leetcode.array;

import java.util.Arrays;

public class Solution66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];    // 默认后面都是0.........
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        int[] nums = new int[]{1, 2, 3};
        int[] res = solution66.plusOne(nums);
        System.out.println(Arrays.toString(res));

        nums = new int[]{4, 3, 2, 1};
        res = solution66.plusOne(nums);
        System.out.println(Arrays.toString(res));

        nums = new int[]{8, 9, 9};
        res = solution66.plusOne(nums);
        System.out.println(Arrays.toString(res));

        nums = new int[]{9, 9, 9};
        res = solution66.plusOne(nums);
        System.out.println(Arrays.toString(res));
    }
}
