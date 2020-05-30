package com.howard.leetcode.eighteen.arrays;

/**
 * Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * @author howard he
 * @create 2019-03-18 09:34
 */
public class Solution189 {

    /**
     * Using Reverse
     *
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || (k = k % nums.length) == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }

    /**
     *
     * Using Cyclic Replacements
     *
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || (k = k % nums.length) == 0) {
            return;
        }
        // times 遍历次数
        int times = 0;
        for (int start = 0; times < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                times ++;
            } while (start != current);
        }
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
