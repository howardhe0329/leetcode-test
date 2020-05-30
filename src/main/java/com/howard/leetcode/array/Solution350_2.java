package com.howard.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个有序的数组的交集
 *
 * @author howard he
 * @create 2019-02-21 14:32
 */
public class Solution350_2 {

    /**
     * 两个有序的数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        List<Integer> resultList = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                resultList.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1 ++;
            } else {
                p2 ++;
            }
        }
        return resultList.stream().mapToInt(item -> item).toArray();
    }
}
