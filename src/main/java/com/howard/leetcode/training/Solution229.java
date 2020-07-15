package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class Solution229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int count1 = 0, count2 = 0;
        Integer candicate1 = -1, candicate2 = -1;
        for (int num : nums) {
            if (num == candicate1) {
                count1++;
                continue;
            }
            if (num == candicate2) {
                count2++;
                continue;
            }
            if (count1 == 0) {
                candicate1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                candicate2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (candicate1 == num)
                count1++;
            else if (candicate2 == num)
                count2++;
        }
        if (count1 > nums.length / 3) result.add(candicate1);
        if (count2 > nums.length / 3) result.add(candicate2);
        return result;
    }

    public static void main(String[] args) {
        Solution229 solution229 = new Solution229();
        int[] nums = new int[]{1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> res = solution229.majorityElement(nums);
        System.out.println(res);
    }
}
