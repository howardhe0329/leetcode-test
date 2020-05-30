package com.howard.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 是否有重复元素
 *
 * @author howard he
 * @create 2019-02-20 15:18
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
