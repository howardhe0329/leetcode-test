package com.howard.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集
 *
 * @author howard he
 * @create 2019-02-21 13:58
 */
public class Solution350_1 {

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>(nums1.length) {
            {
                for (int i = 0; i < nums1.length; i++) {
                    // O(1)
                    put(nums1[i], getOrDefault(nums1[i], 0) + 1);
                }
            }
        };
        List<Integer> resultList = new ArrayList<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            // O(1) 判断nums1是否包含
            if (map1.put(nums2[i], map1.getOrDefault(nums2[i], 0) - 1) > 0) {
                resultList.add(nums2[i]);
            }
        }
        return resultList.stream().mapToInt(item -> item).toArray();
    }
}
