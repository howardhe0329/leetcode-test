package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
//        backtrack(0, nums, new ArrayList<>(), result);
        dfs(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int start, int[] nums, List<Integer> temp, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        dfs(start + 1, nums, new ArrayList<>(temp), result); // no pick the number at this index
        temp.add(nums[start]);
        dfs(start + 1, nums, new ArrayList<>(temp), result); // pick the number at the index
//        temp.remove(temp.size() - 1);
    }

//    private void backtrack(int index, int[] nums, List<Integer> temp, List<List<Integer>> result) {
//        result.add(new ArrayList<>(temp));
//        for (int i = index; i < nums.length; i++) {
//            temp.add(nums[i]);
//            backtrack(i + 1, nums, temp, result);
//            temp.remove(temp.size() - 1);   // O(1) 回溯
//        }
//    }



    public static void main(String[] args) {
        Solution78 solution78 = new Solution78();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = solution78.subsets(nums);
        System.out.println(result);

    }
}
