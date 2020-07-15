package com.howard.leetcode;

import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collector;

public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return nums;
        int[] result = new int[nums.length - k + 1];
        // store index
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1)
                deque.poll();
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offer(i);
            if (i >= k - 1)
                result[i - k + 1] = nums[deque.peek()];
        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        PriorityQueue<Tuple<Integer, Integer>> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new Tuple<>(i, nums[i]));
            if (i >= k - 1) {
                while (queue.peek().index <= i - k)
                    queue.poll();
                result[i - k + 1] = queue.peek().value;
            }
        }
        return result;
    }

    static class Tuple<I extends Integer, E extends Integer> implements Comparable<Tuple> {
        private I index;
        private E value;

        public Tuple(I index, E value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.value.compareTo(that.value);
        }
    }


    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = solution239.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));

        nums = new int[]{1, -1};
        k = 1;
        res = solution239.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));

    }
}
