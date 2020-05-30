package com.howard.leetcode.array;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *
 * @author howard he
 * @create 2019-01-10 17:18
 */
public class MaxSlidingWindowSolution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[] {};
        }
        int[] result = new int[nums.length + 1 - k];
        int ri = 0;
        // store index
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove
            while (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }
            // remove
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            window.offer(i);
            if (i >= k - 1) {
                result[ri++] = nums[window.peek()];
            }
        }
        return result;
    }

    /**
     * 返回滑动窗口的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        if (k <= 1) {
            return nums;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        int[] result = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else {
                result[i - k] = queue.peek();
                queue.remove(nums[i - k]);
                queue.offer(nums[i]);
            }
        }
        result[nums.length - k] = queue.peek();
        return result;
    }
}
