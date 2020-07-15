package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n;
        if (nums == null || (n = nums.length) == 0) return result;
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, temp, result);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> res = solution47.permuteUnique(nums);
        System.out.println(res);
        System.out.println(res.size());
    }
}
