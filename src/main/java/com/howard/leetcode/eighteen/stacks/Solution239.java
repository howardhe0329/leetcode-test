package com.howard.leetcode.eighteen.stacks;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Sliding Window Maximum
 *
 * @author howard he
 * @create 2019-03-29 10:59
 */
public class Solution239 {

    /**
     * use Deque
     * @see java.util.Deque
     *
     * Time complexity: O(nlogk)
     * Space complexity: O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        // store index
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    /**
     * use PriorityQueue
     * @see PriorityQueue
     *
     * Time complexity: O(nlogk)
     * Space complexity: O(k)
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Tuple> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new Tuple(i, nums[i]));
            if (i - k + 1 >= 0) {
                while (heap.peek().index <= i - k) {
                    heap.poll();
                }
                result[i - k + 1] = heap.peek().value;
            }
        }
        return result;
    }

    private static class Tuple<I extends Integer, V extends Integer> implements Comparable<Tuple> {
        private I index;
        private V value;

        public Tuple(I index, V value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.value.compareTo(that.value);
        }

    }
}
