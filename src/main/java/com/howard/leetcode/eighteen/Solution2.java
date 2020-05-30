package com.howard.leetcode.eighteen;

import java.util.*;

/**
 * 众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7
 *
 * @author howard he
 * @create 2019-03-13 10:28
 */
public class Solution2 {

    /**
     * Boyer-Moore Voting 摩尔投票
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * Divide & Conquer
     * Time Complexity: O(nlogn)
     * Space Complexity: O(1)
     * @param nums
     * @return
     */
    public int majorityElement5(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, mid);
        int rightCount = countInRange(nums, right, lo, mid);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i < hi; i++) {
            if (num == nums[i]) {
                count ++;
            }
        }
        return count;
    }

    /**
     * Randomization
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement4(int[] nums) {
        int majorityCount = nums.length / 2;
        Random rand = new Random();
        while (true) {
            int candidate = randRange(rand, 0, nums.length);
            if (countOccurences(nums, nums[candidate]) > majorityCount) {
                return nums[candidate];
            }
        }
    }

    /**
     * 统计出现次数
     * @param nums
     * @param num
     * @return
     */
    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                count ++;
            }
        }
        return count;
    }

    /**
     * 随机选举一个索引位置
     * @param rand
     * @param min
     * @param max
     * @return
     */
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }


    /**
     * that's well
     * Sorting
     * <p>
     * Time complexity: O(nlogn)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * Hash Table
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        return countMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    /**
     * Brute Force
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int majorityCount = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return nums[i];
            }
        }
        return 0;
    }
}
