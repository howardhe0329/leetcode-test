package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n;
        if (nums == null || (n = nums.length) == 0) return result;
        boolean[] visited = new boolean[n];
        backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> temp, List<List<Integer>> result) {
        // terminator
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // logic process
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            // drill down
            backtrack(nums, visited, temp, result);
            // reverse status
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = solution46.permute(nums);
        System.out.println(res);
        System.out.println(res.size());
    }
}
