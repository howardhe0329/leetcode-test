package com.howard.leetcode.eighteen.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 *
 * @author howard he
 * @create 2019-03-27 10:12
 */
public class Solution215 {

    private Random rand = new Random();

    /**
     * 利用快排的思想
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int j = partition(nums, left, right);
            if (j < k) {
                left = j + 1;
            } else if (j > k) {
                right = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
//        int randIndex = rand.nextInt(right - left + 1) + left;
//        swap(nums, left, randIndex);
        int i = left;
        int j = right + 1;
        while (true) {
            while (i < right && less(nums[++i], nums[left]));
            while (j > left && less(nums[left], nums[--j]));
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void shuffle(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = rand.nextInt(nums.length - i) + i;
            swap(nums, i, n);
        }
    }

    private boolean less(int v, int w) {
        return v < w;
    }


    /**
     * 利用优先级队列，然后取出堆顶的元素
     *
     * Time complexity: O(nlogk)
     * Space complexity: O(k)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int n: nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 先对数组进行排序，然后返回第k的元素
     *
     * Time complexity: O(nlogn)
     * Space complexity: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
