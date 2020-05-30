package com.howard.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 求众数
 *
 * @author howard he
 * @create 2019-03-11 15:56
 */
public class Solution169 {

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }

    /**
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int item = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry:
                map.entrySet()) {
            if (entry.getValue() > max) {
                item = entry.getKey();
            }
        }
        return item;
    }
}
