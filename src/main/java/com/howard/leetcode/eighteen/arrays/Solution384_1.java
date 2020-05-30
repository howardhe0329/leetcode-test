package com.howard.leetcode.eighteen.arrays;

import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 *
 * @author howard he
 * @create 2019-03-20 09:30
 */
public class Solution384_1 {

    private int[] array;
    private int[] original;

    private Random rand = new Random();

    public Solution384_1(int[] nums) {
        this.array = nums;
        this.original = nums.clone();
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @return
     */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @return
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            // Fisher-Yates algorithm
            swap(array, i, getRangeAt(i, array.length));
        }
        return array;
    }

    private int getRangeAt(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
