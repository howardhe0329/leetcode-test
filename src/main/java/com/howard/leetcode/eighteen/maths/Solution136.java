package com.howard.leetcode.eighteen.maths;

import java.util.*;

/**
 * Single Number
 *
 * @author howard he
 * @create 2019-04-10 09:06
 */
public class Solution136 {

    /**
     * use Map
     *
     * Time complexity: O(N)
     * Space complexity: O(N)
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry:
             map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * the first, sort
     * Time complexity: O(NlogN)
     * Space complexity: O(1)
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int n;
        if ((n = nums.length) == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }
        for (int i = 1; i < n -1; i ++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * Time complexity: O(N)
     * Space complexity: O(1)
     *
     * if we take XOR of zero and some bit, it will return that bit.
     *  a ^ 0 = a
     *
     * if we take XOR of two same bits, it will return 0
     *  a ^ a = 0
     *
     *  a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
