package com.howard.leetcode;

import java.util.*;

public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        int[] res = solution347.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));

        nums = new int[] {1};
        k = 1;
        res = solution347.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
