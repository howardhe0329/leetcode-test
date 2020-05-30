package com.howard.leetcode.eighteen.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * @author howard he
 * @create 2019-03-18 11:29
 */
public class Solution217 {

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Time complexity: O(nlogn)
     * Space complexity: O(N)
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> sets = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!sets.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


}
