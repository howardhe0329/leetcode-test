package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution90 solution90 = new Solution90();
        int[] nums = new int[]{2, 2, 1, 2};
        List<List<Integer>> res = solution90.subsetsWithDup(nums);
        System.out.println(res);
    }


}
