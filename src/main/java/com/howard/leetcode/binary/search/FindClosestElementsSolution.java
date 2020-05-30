package com.howard.leetcode.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 *
 * @author howard he
 * @create 2019-01-08 09:52
 */
public class FindClosestElementsSolution {

    /**
     *
     * @param nums
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        if (x <= nums[0]) {
            return copy(nums, 0, k);
        } else if (x >= nums[nums.length - 1]) {
            return copy(nums, nums.length - k, nums.length);
        } else {
            int index = Arrays.binarySearch(nums, x);
            if (index < 0) {
                index = -index - 1;
            }
            int low = Math.max(0, index - k - 1);
            int high = Math.min(nums.length - 1, index + k - 1);
            while (high - low > k - 1) {
                if (low < 0 || (x - nums[low] <= nums[high] - x)) {
                    high--;
                } else if (high > nums.length - 1 || (x - nums[low] > nums[high] - x)) {
                    low++;
                } else {
                    System.out.println("unhandled case: " + low + " " + high);
                }
            }
            return copy(nums, low, high + 1);
        }
    }



    private List<Integer> copy(int[] nums, int start, int end) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    public List<Integer> findClosestElements1(int[] nums, int k, int x) {
        return null;
    }
}
