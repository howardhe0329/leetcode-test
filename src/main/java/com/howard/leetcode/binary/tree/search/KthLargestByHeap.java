package com.howard.leetcode.binary.tree.search;

import com.howard.leetcode.binary.tree.heap.Heap;

/**
 * 查找第K大元素，基于堆数据结构
 *
 * @author howard he
 * @create 2019-01-10 11:14
 */
public class KthLargestByHeap {

    private Heap<Integer> heap;
    private int k;

    public KthLargestByHeap(int k, int[] nums) {
        this.k = k;
        heap = new Heap(k);
        for (int n: nums) {
            add(n);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.insert(val);
        } else if (heap.top() < val) {
            heap.removeTop();
            heap.insert(val);
        }
        return heap.top();
    }
}
