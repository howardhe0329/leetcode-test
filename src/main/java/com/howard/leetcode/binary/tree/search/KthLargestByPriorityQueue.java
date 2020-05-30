package com.howard.leetcode.binary.tree.search;

import java.util.PriorityQueue;

/**
 * 数据流中的第K大元素
 * <p>
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 *
 * @author howard he
 * @create 2019-01-10 10:12
 */
public class KthLargestByPriorityQueue {

    /**
     * 优先级队列
     */
    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargestByPriorityQueue(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        // 初始化队列中的数据
        for (int n : nums) {
            add(n);
        }
    }

    /**
     * 利用java中的PriorityQueue（优先级队列）来实现
     *
     * @param val
     * @return 返回第k大的元素
     */
    public int add(int val) {
        // 判断队列的大小是否小于k
        // O(1)
        if (queue.size() < k) {
            // 直接入队 O(logN)
            queue.offer(val);
            // 取出队列中第一个元素，如果小于要插入的值，那么就删除第一个元素，并插入新值
            // queue.peek() O(1)
        } else if (queue.peek() < val) {
            //出队 O(1)
            queue.poll();
            // 入队 O(logN)
            queue.offer(val);
        }
        // O(1)
        return queue.peek();
    }
}
