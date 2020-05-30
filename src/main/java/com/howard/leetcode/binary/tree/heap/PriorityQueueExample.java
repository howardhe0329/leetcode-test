package com.howard.leetcode.binary.tree.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 优先级队列
 *
 * @author howard he
 * @create 2019-03-29 15:09
 */
public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        heap.offer(21);
        heap.offer(23);
        heap.offer(11);
        heap.offer(16);
        heap.offer(9);
        heap.offer(1);
        heap.offer(40);
        System.out.println(Arrays.toString(heap.toArray()));
        heap.offer(22);
        heap.offer(15);
        heap.offer(7);
        heap.offer(11);
        heap.offer(11);
        System.out.println(Arrays.toString(heap.toArray()));

        while (!heap.isEmpty()) {
            System.out.format("%d, ", heap.poll());
        }
    }
}
