package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4item {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = len - 1, sum, x;
                int temp = target - nums[i] - nums[j];
                while (left < right) {
                    sum = nums[left] + nums[right];
                    if (sum < temp) left++;
                    else if (sum > temp) right--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        x = nums[left];
                        while (++left < right && x == nums[left]) ;
                        x = nums[right];
                        while (left < --right && x == nums[right]) ;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            threeSum(nums, target - nums[i], i + 1, len - 1, result, nums[i]);
        }
        return result;
    }

    private void threeSum(int[] nums, int target, int left, int right, List<List<Integer>> result, int item) {
        if (left + 1 >= right) return;
        for (int i = left; i < right - 1; i++) {
            if (i > left && nums[i] == nums[i - 1]) continue;
            twoSum(nums, target - nums[i], i + 1, right, result, item, nums[i]);
        }
    }

    private void twoSum(int[] nums, int target, int left, int right, List<List<Integer>> result, int item, int item1) {
        if (left >= right) return;
        int i = left, j = right, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                result.add(Arrays.asList(item, item1, nums[i], nums[j]));
                x = nums[i];
                while (++i < j && x == nums[i]) ;
                x = nums[j];
                while (i < --j && x == nums[j]) ;
            }
            if (sum < target) i++;
            if (sum > target) j--;
        }
    }

    public static void main(String[] args) {
        Solution4item solution4item = new Solution4item();
        List<List<Integer>> res = solution4item.fourSum1(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
        System.out.println(res);
    }


}
