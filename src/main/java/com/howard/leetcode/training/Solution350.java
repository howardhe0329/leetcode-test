package com.howard.leetcode.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                result.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] < nums2[i1]) i1++;
            else i2++;
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution350 solution350 = new Solution350();
        int[] res = solution350.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(res));

    }
}
