package com.howard.leetcode.eighteen.arrays;

import java.util.*;

/**
 * 两个数组交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author howard he
 * @create 2019-03-20 10:32
 */
public class Solution350 {

    /**
     *
     * Time complexity: O(max(m, n))
     * Space complexity: O(max(m, n))
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> resultList;
        if (nums1.length > nums2.length) {
            resultList = helper(nums2, nums1);
        } else {
            resultList = helper(nums1, nums2);
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> helper(int[] mins, int[] maxs) {
        List<Integer> resultList = new ArrayList<>(mins.length);
        Map<Integer, Integer> dictMap = convertMap(maxs);
        for (int i = 0; i < mins.length; i++) {
            Integer v = dictMap.put(mins[i], dictMap.getOrDefault(mins[i], 0) - 1);
            if (v != null && v > 0) {
                resultList.add(mins[i]);
            }
        }
        return resultList;
    }

    private Map<Integer, Integer> convertMap(int[] nums) {
        Map<Integer, Integer> dictMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            dictMap.put(nums[i], dictMap.getOrDefault(nums[i], 0) + 1);
        }
        return dictMap;
    }

    /**
     *
     * Time complexity: O(max(m, n)logmax(m, n))
     * Space complexity: O(min(m, n))
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        int min = nums1.length < nums2.length ? nums1.length : nums2.length;
        List<Integer> resultList = new ArrayList<>(min);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0;
        int b = 0;
        while (a < nums1.length && b < nums2.length) {
            if (nums1[a] == nums2[b]) {
                resultList.add(nums1[a]);
                a++;
                b++;
            } else if (nums1[a] < nums2[b]) {
                a ++;
            } else {
                b++;
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
