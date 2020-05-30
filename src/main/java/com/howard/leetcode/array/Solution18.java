package com.howard.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 四数之和
 *
 * @author howard he
 * @create 2019-03-04 15:58
 */
public class Solution18 {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                map.get(tmp).add(i);
            } else {
                map.put(tmp, Stream.of(i).collect(Collectors.toList()));
            }
        }
        System.out.println(map);

        return resultList;
    }
}
