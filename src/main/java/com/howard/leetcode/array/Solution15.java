package com.howard.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 三数之和
 *
 * @author howard he
 * @create 2019-03-04 14:15
 */
public class Solution15 {

    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int result = nums[i] + nums[left] + nums[right];
                if (result < 0) {
                    left ++;
                } else if (result > 0) {
                    right --;
                } else {
                    resultList.add(Stream.of(nums[i], nums[left], nums[right]).collect(Collectors.toList()));
                    left ++;
                    right --;
                }
            }
        }
        return resultList;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int k = 0 - nums[i] - nums[j];
                if (map.containsKey(nums[j])) {
                    resultList.add(Stream.of(nums[i], k, nums[j]).collect(Collectors.toList()));
                } else {
                    map.put(k, j);
                }
            }
        }
        return resultList;
    }
}
