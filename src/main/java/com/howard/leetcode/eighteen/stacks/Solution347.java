package com.howard.leetcode.eighteen.stacks;

import java.util.*;

/**
 * Top K Frequent Elements
 *
 * @author howard he
 * @create 2019-03-29 09:40
 */
public class Solution347 {

    /**
     *
     * Map + Heap
     *
     * Time complexity: O(nlogk)
     * Space complexity: O(N)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // step 1. create map
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        // step 2. heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(countMap::get));
        for (int n : countMap.keySet()) {
            heap.offer(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // build output
        List<Integer> topK = new LinkedList<>();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }
}
