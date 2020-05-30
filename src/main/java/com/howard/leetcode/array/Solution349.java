package com.howard.leetcode.array;

import java.util.*;

/**
 * 两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author howard he
 * @create 2019-02-20 09:27
 */
public class Solution349 {

    /**
     * 两个数组交集
     * 要理解set集合中各种操作的时间复杂度
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            int item = nums2[i];
            // O(1)
            if (set1.contains(item)) {
                set2.add(item);
            }
        }
        return set2.stream().mapToInt(item -> item).toArray();
    }
}
